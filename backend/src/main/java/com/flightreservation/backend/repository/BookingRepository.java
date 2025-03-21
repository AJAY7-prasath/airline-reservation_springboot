package com.flightreservation.backend.repository;

import com.flightreservation.backend.model.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface BookingRepository extends MongoRepository<Booking,String>{
    List<Booking> findByUserEmail(String email);
}
