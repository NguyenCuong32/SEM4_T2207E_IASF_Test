package com.example.ExamIASF.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table
public class vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   Integer vehicle_id ;

    @Column
    @NotNull(message = "Name is Required")
    String vehicle_name;
    @Column
    @NotNull(message = "Name is Required")
    String vehicle_model;
    @Column
    @NotNull(message = "Name is Required")
 Integer year_of_manufacture;
    @Column
 String vehicle_color;
    //contructor

    public vehicle() {
    }

    public vehicle(String vehicle_name, String vehicle_model, Integer year_of_manufacture, String vehicle_color) {
        this.vehicle_name = vehicle_name;
        this.vehicle_model = vehicle_model;
        this.year_of_manufacture = year_of_manufacture;
        this.vehicle_color = vehicle_color;
    }

//getter setter

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
