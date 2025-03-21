package com.flightreservation.backend.model;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor


public class User {
    @Id
    private String id;
    private String email;
    private String password;
    private String role;

}
