package com.flightreservation.backend.repository;

import com.flightreservation.backend.model.Flight;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface FlightRepository extends MongoRepository<Flight, String>{
    List<Flight> findByOriginAndDestination(String origin, String destination);
}
