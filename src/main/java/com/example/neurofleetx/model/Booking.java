package com.example.neurofleetx.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pickupLocation;
    private String dropLocation;

    private double distanceKm;
    private int etaMinutes;
    private double price;

    // REQUESTED, ACCEPTED, ONGOING, COMPLETED
    private String status;

    private Long driverId;
}