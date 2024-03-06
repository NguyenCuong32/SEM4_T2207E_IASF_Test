package org.example.exam.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vehicle")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id", nullable = false)
    public int vehicle_id;

    @Column(name = "vehicle_name", nullable = false)
    @NotEmpty(message = "The Vehicle Name Field is not empty.")
    public String vehicle_name;

    @Column(name = "vehicle_model", nullable = false)
    @NotEmpty(message = "The Vehicle Model Field is not empty.")
    public String vehicle_model;

    @Column(name = "year_of_manufacture", nullable = false)
    @NotEmpty(message = "The Year of Manufacture Field is not empty.")
    public int year_of_manufacture;

    @Column(name = "vehicle_color", nullable = false)
    @NotEmpty(message = "The Vehicle Color Field is not empty.")
    public String vehicle_color;
}
