package com.example.neurofleetx.controller;

import com.example.neurofleetx.dto.VehicleHealthResponse;
import com.example.neurofleetx.service.VehicleHealthService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/neurofleetx/health")
@CrossOrigin(origins = "http://localhost:3000")  // ✅ ADD THIS
public class VehicleHealthController {

    private final VehicleHealthService vehicleHealthService;

    public VehicleHealthController(VehicleHealthService vehicleHealthService) {
        this.vehicleHealthService = vehicleHealthService;
    }

    @GetMapping
    public List<VehicleHealthResponse> getVehicleHealthStatus() {
        return vehicleHealthService.getVehicleHealth();
    }
}