package com.example.neurofleetx.service;

import com.example.neurofleetx.model.Vehicle;
import com.example.neurofleetx.model.VehicleStatus;
import com.example.neurofleetx.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class TelemetrySimulatorService {

    private final VehicleRepository vehicleRepository;
    private final Random random = new Random();

    public TelemetrySimulatorService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public void simulateTelemetry() {
        List<Vehicle> vehicles = vehicleRepository.findAll();

        for (Vehicle v : vehicles) {

            // Simulate battery & fuel drain
            if (v.getBatteryLevel() != null) {
                v.setBatteryLevel(Math.max(0, v.getBatteryLevel() - random.nextInt(3)));
            }

            if (v.getFuelLevel() != null) {
                v.setFuelLevel(Math.max(0, v.getFuelLevel() - random.nextInt(2)));
            }

            // ✅ STATUS UPDATE (ENUM SAFE)
            if (
                    (v.getBatteryLevel() != null && v.getBatteryLevel() < 20) ||
                            (v.getFuelLevel() != null && v.getFuelLevel() < 20)
            ) {
                v.setStatus(VehicleStatus.NEEDS_SERVICE);
            } else {
                v.setStatus(VehicleStatus.IN_USE);
            }

            vehicleRepository.save(v);
        }
    }
}