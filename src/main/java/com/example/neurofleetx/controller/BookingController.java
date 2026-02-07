package com.example.neurofleetx.controller;

import com.example.neurofleetx.model.Booking;
import com.example.neurofleetx.repository.BookingRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingRepository bookingRepository;

    public BookingController(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    // ✅ DRIVER PAGE CALLS THIS
    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    // ✅ BOOKING PAGE CALLS THIS
    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingRepository.save(booking);
    }

    // ✅ DRIVER ACCEPT / END RIDE CALLS THIS
    @PutMapping("/{id}/status")
    public Booking updateStatus(
            @PathVariable Long id,
            @RequestBody Map<String, String> body
    ) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        booking.setStatus(body.get("status"));
        return bookingRepository.save(booking);
    }
}