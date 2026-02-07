package com.example.neurofleetx.controller;

import com.example.neurofleetx.dto.*;
import com.example.neurofleetx.service.RouteService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/routes")
@CrossOrigin(origins = "http://localhost:3000")
public class RouteController {

    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @PostMapping("/calculate")
    public AIRouteResponse calculate(@RequestBody RouteRequest request) {
        return routeService.calculateRoute(request);
    }
}