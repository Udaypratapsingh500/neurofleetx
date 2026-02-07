package com.example.neurofleetx.service;

import com.example.neurofleetx.dto.VehicleHealthResponse;
import com.example.neurofleetx.model.Vehicle;
import com.example.neurofleetx.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleHealthService {

    private final VehicleRepository vehicleRepository;

    public VehicleHealthService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<VehicleHealthResponse> getVehicleHealth() {

        List<Vehicle> vehicles = vehicleRepository.findAll();

        return vehicles.stream().map(vehicle -> {

            int healthScore = calculateHealthScore(vehicle);
            String status = determineStatus(healthScore);

            return new VehicleHealthResponse(
                    vehicle.getVehicleNumber(),
                    healthScore,
                    status
            );

        }).collect(Collectors.toList());
    }

    private int calculateHealthScore(Vehicle vehicle) {
        int battery = vehicle.getBatteryLevel();
        int fuel = vehicle.getFuelLevel();

        // Simple predictive logic (simulation)
        return (battery + fuel) / 2;
    }

    private String determineStatus(int healthScore) {
        if (healthScore >= 70) {
            return "HEALTHY";
        } else if (healthScore >= 40) {
            return "DUE";
        } else {
            return "CRITICAL";
        }
    }
}