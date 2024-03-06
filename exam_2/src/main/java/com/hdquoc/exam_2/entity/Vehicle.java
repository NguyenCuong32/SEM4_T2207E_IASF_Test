package com.hdquoc.exam_2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "vehicle")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vehicle_id;

    @Column(name = "vehicle_name", nullable = false, unique = true)
    private String vehicle_name;

    @Column(name = "vehicle_model")
    private String vehicle_model;
    @Column(name = "year_of_manufacture")
    private int year_of_manufacture;

    @Column(name = "vehicle_color")
    private String vehicle_color;
}
