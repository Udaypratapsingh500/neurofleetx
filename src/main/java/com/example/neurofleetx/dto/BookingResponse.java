package com.example.neurofleetx.dto;

public class BookingResponse {

    private Long id;
    private String pickupLocation;
    private String dropLocation;
    private String status;

    public BookingResponse(Long id, String pickupLocation, String dropLocation, String status) {
        this.id = id;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public String getDropLocation() {
        return dropLocation;
    }

    public String getStatus() {
        return status;
    }
}