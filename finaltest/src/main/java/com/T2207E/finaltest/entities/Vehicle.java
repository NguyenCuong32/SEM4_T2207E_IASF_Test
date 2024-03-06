package com.T2207E.finaltest.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id")

    private int vehicleId;

    @Column(name = "vehicle_name", nullable = false, length = 64)
    @NotBlank(message = "*vehicle name is required")
    @Size(max = 64, message = "vehicle name cannot exceed 64 characters")
    private String vehicleName;

    @Column(name = "vehicle_model", nullable = false, length = 10)
    @NotBlank(message = "*vehicle model is required")
    @Size(max = 10, message = "vehicle model cannot exceed 64 characters")
    private String vehicleModel;

    @Column(name = "year_of_manufacture", nullable = false)
    @NotBlank(message = "*year of manufacture is required")
    private String yearOfManuFacture;

    @Column(name = "vehicle_color", nullable = false)
    @NotBlank(message = "*vehicle color is required")
    private String vehicleColor;

}
