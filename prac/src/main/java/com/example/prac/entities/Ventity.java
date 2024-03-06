package com.example.prac.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name ="vehicle")
@Entity
public class Ventity {
    @Id
    @Column (name = "vehicle_id")
    private Long vehicle_id;
    public String tvehicle_name	;
    public String vehicle_model;
    public int year_of_manufacture;
    public String vehicle_color;

    public Long getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(Long vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public String getTvehicle_name() {
        return tvehicle_name;
    }

    public void setTvehicle_name(String tvehicle_name) {
        this.tvehicle_name = tvehicle_name;
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

    public Ventity(Long vehicle_id, String tvehicle_name, String vehicle_model, int year_of_manufacture, String vehicle_color) {
        this.vehicle_id = vehicle_id;
        this.tvehicle_name = tvehicle_name;
        this.vehicle_model = vehicle_model;
        this.year_of_manufacture = year_of_manufacture;
        this.vehicle_color = vehicle_color;
    }

    public Ventity() {
    }

    @Override
    public String toString() {
        return "Ventity{" +
                "vehicle_id=" + vehicle_id +
                ", tvehicle_name='" + tvehicle_name + '\'' +
                ", vehicle_model='" + vehicle_model + '\'' +
                ", year_of_manufacture=" + year_of_manufacture +
                ", vehicle_color='" + vehicle_color + '\'' +
                '}';
    }
}
