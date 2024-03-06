package com.example.prac.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vehicle")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer vehicleId;

    @Column(name = "vehicle_name", nullable = false)
    private String vehicleName;

    @Column(name = "vehicle_model", nullable = false)
    private String vehicleModel;

    @Column(name = "year_of_manufacture", nullable = false)
    private int yearOfManufacture;

    @Column(name = "vehicle_color")
    private String vehicleColor;

}