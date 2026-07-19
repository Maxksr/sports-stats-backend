package com.random.modnar.user;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public enum Role {
        USER,
        ADMIN
    }

    @Enumerated(EnumType.STRING)
    private Role role;
}