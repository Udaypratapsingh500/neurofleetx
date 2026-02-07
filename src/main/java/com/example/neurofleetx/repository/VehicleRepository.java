package com.example.neurofleetx.repository;

import com.example.neurofleetx.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}