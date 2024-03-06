package com.example.IASP_test.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="vehicle_id")
    public Integer vehicle_id;
    @Column(name ="vehicle_name")
    public String vehicle_name;
    @Column(name ="vehicle_model")
    public String vehicle_model;
    @Column(name ="year_of_manufacture")
    public Integer year_of_manufacture;
    @Column(name ="vehicle_color")
    public String vehicle_color;
    public Vehicle() {
    }

    public Vehicle(Integer vehicle_id, String vehicle_name, String vehicle_model, Integer year_of_manufacture, String vehicle_color) {
        this.vehicle_id = vehicle_id;
        this.vehicle_name = vehicle_name;
        this.vehicle_model = vehicle_model;
        this.year_of_manufacture = year_of_manufacture;
        this.vehicle_color = vehicle_color;
    }

    public Integer getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(Integer vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public String getVehicle_name() {
        return vehicle_name;
    }

    public void setVehicle_name(String vehicle_name) {
        this.vehicle_name = vehicle_name;
    }

    public String getVehicle_model() {
        return vehicle_model;
    }

    public void setVehicle_model(String vehicle_model) {
        this.vehicle_model = vehicle_model;
    }

    public Integer getYear_of_manufacture() {
        return year_of_manufacture;
    }

    public void setYear_of_manufacture(Integer year_of_manufacture) {
        this.year_of_manufacture = year_of_manufacture;
    }

    public String getVehicle_color() {
        return vehicle_color;
    }

    public void setVehicle_color(String vehicle_color) {
        this.vehicle_color = vehicle_color;
    }
}
