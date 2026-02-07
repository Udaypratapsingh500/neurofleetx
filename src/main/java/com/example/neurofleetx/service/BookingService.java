package com.example.neurofleetx.service;

import com.example.neurofleetx.dto.BookingRequest;
import com.example.neurofleetx.model.Booking;
import com.example.neurofleetx.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Booking createBooking(BookingRequest request) {

        Booking booking = Booking.builder()
                .pickupLocation(request.getPickupLocation())
                .dropLocation(request.getDropLocation())
                .distanceKm(12.5)
                .etaMinutes(35)
                .price(350)
                .status("REQUESTED")
                .build();

        return bookingRepository.save(booking);
    }

    public List<Booking> getPendingBookings() {
        return bookingRepository.findByStatus("REQUESTED");
    }

    public Booking acceptBooking(Long bookingId, Long driverId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        booking.setDriverId(driverId);
        booking.setStatus("ACCEPTED");

        return bookingRepository.save(booking);
    }
}