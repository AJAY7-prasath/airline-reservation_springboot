package com.flightreservation.backend.controller;

import com.flightreservation.backend.model.Flight;
import com.flightreservation.backend.repository.FlightRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/flights")
public class FlightController {
    private final FlightRepository flightRepository;

    public FlightController(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @PostMapping
    public ResponseEntity<Flight> addFlight(@RequestBody Flight flight) {
        return ResponseEntity.ok(flightRepository.save(flight));
    }

    @GetMapping
    public ResponseEntity<List<Flight>> getFlights() {
        return ResponseEntity.ok(flightRepository.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFlight(@PathVariable String id) {
        flightRepository.deleteById(id);
        return ResponseEntity.ok("Flight deleted successfully");
    }
}
