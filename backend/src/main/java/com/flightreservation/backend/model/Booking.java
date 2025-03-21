package com.flightreservation.backend.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bookings")
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Booking {
    @Id
    private String id;
    private String userEmail;
    private String flightId;
    private String seatNumber;
    private String status;
}
