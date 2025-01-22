package com.example.flashcard.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity @Builder @Data @Getter @Setter
@Table(name = "users")
@AllArgsConstructor @NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username", length = 50)
    private String userName;

    @Column(name = "password", length = 50)
    private String password;

    @Column(name = "address", length = 50)
    private String address;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "firstname", length = 50)
    private String firstName;

    @Column(name = "datecreated", length = 50)
    private LocalDate dateCreated;
}
