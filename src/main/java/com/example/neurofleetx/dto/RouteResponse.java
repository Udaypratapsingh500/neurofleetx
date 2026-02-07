package com.example.neurofleetx.dto;

public class RouteResponse {

    // Core metrics
    private double distanceKm;
    private int etaMinutes;

    // AI route classification
    private String routeType; // FASTEST | ECO | SAFE | BALANCED

    // AI impact analysis
    private int trafficImpact; // %
    private int energyImpact;  // %

    // Decision intelligence
    private boolean recommended;
    private String aiReason;

    // Map visualization (future)
    private String polyline;

    // ML readiness
    private double confidenceScore; // 0.0 – 1.0

    // ✅ FINAL CONSTRUCTOR
    public RouteResponse(
            double distanceKm,
            int etaMinutes,
            String routeType,
            int trafficImpact,
            int energyImpact,
            boolean recommended,
            String aiReason,
            String polyline,
            double confidenceScore
    ) {
        this.distanceKm = distanceKm;
        this.etaMinutes = etaMinutes;
        this.routeType = routeType;
        this.trafficImpact = trafficImpact;
        this.energyImpact = energyImpact;
        this.recommended = recommended;
        this.aiReason = aiReason;
        this.polyline = polyline;
        this.confidenceScore = confidenceScore;
    }

    public double getDistanceKm() {
        return distanceKm;
    }

    public int getEtaMinutes() {
        return etaMinutes;
    }

    public String getRouteType() {
        return routeType;
    }

    public int getTrafficImpact() {
        return trafficImpact;
    }

    public int getEnergyImpact() {
        return energyImpact;
    }

    public boolean isRecommended() {
        return recommended;
    }

    public String getAiReason() {
        return aiReason;
    }

    public String getPolyline() {
        return polyline;
    }

    public double getConfidenceScore() {
        return confidenceScore;
    }
}