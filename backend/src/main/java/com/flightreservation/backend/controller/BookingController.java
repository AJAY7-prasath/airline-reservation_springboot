package com.flightreservation.backend.controller;

import com.flightreservation.backend.model.Booking;
import com.flightreservation.backend.repository.BookingRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    private final BookingRepository bookingRepository;

    public BookingController(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @PostMapping
    public ResponseEntity<Booking> bookFlight(@RequestBody Booking booking) {
        return ResponseEntity.ok(bookingRepository.save(booking));
    }

    @GetMapping("/{email}")
    public ResponseEntity<List<Booking>> getUserBookings(@PathVariable String email) {
        return ResponseEntity.ok(bookingRepository.findByUserEmail(email));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> cancelBooking(@PathVariable String id) {
        bookingRepository.deleteById(id);
        return ResponseEntity.ok("Booking cancelled successfully");
    }
}

