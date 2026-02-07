package com.example.neurofleetx.dto;

public class AIRouteOption {

    private String type;        // FAST, ECO, SAFE
    private int etaMinutes;
    private boolean recommended;
    private String color;
    private double[][] path;    // lat-lng pairs

    public AIRouteOption(String type, int etaMinutes, boolean recommended, String color, double[][] path) {
        this.type = type;
        this.etaMinutes = etaMinutes;
        this.recommended = recommended;
        this.color = color;
        this.path = path;
    }

    public String getType() {
        return type;
    }

    public int getEtaMinutes() {
        return etaMinutes;
    }

    public boolean isRecommended() {
        return recommended;
    }

    public String getColor() {
        return color;
    }

    public double[][] getPath() {
        return path;
    }
}