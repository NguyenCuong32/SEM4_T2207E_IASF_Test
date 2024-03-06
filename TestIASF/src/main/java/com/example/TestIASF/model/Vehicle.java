package com.example.TestIASF.model;

import jakarta.persistence.*;

@Entity
@Table(name  ="vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="vehicle_id")
    public Integer vehicleId;
    @Column(name="vehicle_name")
    public String vehicleName;
    @Column(name="vehicle_model")
    public String vehicleModel;
    @Column(name="year_of_manufacture")
    public Integer yearOfManufacture;
    @Column(name="vehicle_color")
    public String vehicleColor;

    public Vehicle() {
    }

    public Vehicle(Integer vehicleId, String vehicleName, String vehicleModel, Integer yearOfManufacture, String vehicleColor) {
        this.vehicleId = vehicleId;
        this.vehicleName = vehicleName;
        this.vehicleModel = vehicleModel;
        this.yearOfManufacture = yearOfManufacture;
        this.vehicleColor = vehicleColor;
    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public Integer getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(Integer yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }
}
