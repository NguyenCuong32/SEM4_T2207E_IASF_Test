package com.Aptech.vehicle.production.Entiry;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer vehicle_id;

    @Column(name = "vehicle_name")
    @NotNull(message = "Name is required")
    @Size(min = 1, max = 64)
    private String vehicle_name;

    @Column(name = "vehicle_model")
    @NotNull(message = "Model is required")
    @Size(min = 1, max = 10)
    private String vehicle_model;

    @Column(name = "year_of_manufacture")
    @NotNull(message = "Year of manufacture is required")
    @Size(min = 1, max = 11)
    private int year_of_manufacture;

    @Column(name = "vehicle_color")
    @NotNull(message = "Vehicle Color is required")
    @Size(min = 1, max = 16)
    private String vehicle_color;

    public Vehicle() {
    }

    public Vehicle(Integer vehicle_id, String vehicle_name, String vehicle_model, int year_of_manufacture, String vehicle_color) {
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

    public int getYear_of_manufacture() {
        return year_of_manufacture;
    }

    public void setYear_of_manufacture(int year_of_manufacture) {
        this.year_of_manufacture = year_of_manufacture;
    }

    public String getVehicle_color() {
        return vehicle_color;
    }

    public void setVehicle_color(String vehicle_color) {
        this.vehicle_color = vehicle_color;
    }
}
