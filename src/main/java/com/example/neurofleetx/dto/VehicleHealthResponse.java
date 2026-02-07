package com.example.neurofleetx.dto;

public class VehicleHealthResponse {

    private String vehicleNumber;
    private int healthScore;
    private String status; // HEALTHY, DUE, CRITICAL

    public VehicleHealthResponse(String vehicleNumber, int healthScore, String status) {
        this.vehicleNumber = vehicleNumber;
        this.healthScore = healthScore;
        this.status = status;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public int getHealthScore() {
        return healthScore;
    }

    public String getStatus() {
        return status;
    }
}