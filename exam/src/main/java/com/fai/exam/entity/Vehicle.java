package com.fai.exam.entity;

import jakarta.persistence.*;
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
    @Column(name = "vehicle_id")
    public Integer vehicle_id;

    @Column(name = "vehicle_name")
    public String vehicle_name;

    @Column(name = "vehicle_model")
    public String vehicle_model;

    @Column(name = "year_of_manufacture")
    public Integer year_of_manufacture;

    @Column(name = "vehicle_color")
    public String vehicle_color;
}
