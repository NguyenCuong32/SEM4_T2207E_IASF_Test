package com.example.IassexamTranThiMaiHien.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "vehicle")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="vehicle_id")
    public Integer vehicle_id;
    @Column(name = "vehicle_name",length = 64)
    @NotNull
    public String vehicle_name;
    @NotNull
    @Column(name = "vehicle_model",length = 10)
    public String vehicle_model;
    @NotNull
    @Column(name = "year_of_manufacture",length = 11)
    public Integer year_of_manufacture;
    @NotNull
    @Column(name = "vehicle_color",length = 16)
    public String vehicle_color;
}
