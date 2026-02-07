package com.example.neurofleetx.service;

import com.example.neurofleetx.dto.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {

    public AIRouteResponse calculateRoute(RouteRequest request) {

        double[][] fastRoute = {
                {request.getStartLat(), request.getStartLng()},
                {request.getEndLat(), request.getEndLng()}
        };

        double[][] ecoRoute = {
                {request.getStartLat(), request.getStartLng()},
                {request.getStartLat() + 0.03, request.getStartLng() + 0.02},
                {request.getEndLat(), request.getEndLng()}
        };

        double[][] safeRoute = {
                {request.getStartLat(), request.getStartLng()},
                {request.getStartLat() + 0.05, request.getStartLng() - 0.03},
                {request.getEndLat(), request.getEndLng()}
        };

        List<AIRouteOption> routes = List.of(
                new AIRouteOption("FAST", 32, true, "blue", fastRoute),
                new AIRouteOption("ECO", 37, false, "green", ecoRoute),
                new AIRouteOption("SAFE", 41, false, "orange", safeRoute)
        );

        return new AIRouteResponse(routes);
    }
}