package com.Aptech.vehicle.production.Entiry;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;

    @Column(name = "password")
    @NotNull(message = "Password is required")
    @Size(min = 1, max = 68)
    private String password;

    @Column(name = "is_active")
    private int is_active;
}
