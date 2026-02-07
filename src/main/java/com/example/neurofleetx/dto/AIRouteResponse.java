package com.example.neurofleetx.dto;

import java.util.List;

public class AIRouteResponse {

    private List<AIRouteOption> routes;

    public AIRouteResponse(List<AIRouteOption> routes) {
        this.routes = routes;
    }

    public List<AIRouteOption> getRoutes() {
        return routes;
    }
}