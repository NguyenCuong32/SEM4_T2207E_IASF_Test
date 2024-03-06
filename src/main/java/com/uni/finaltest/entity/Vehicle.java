package com.uni.finaltest.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Vehicle {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "vehicle_id")
    private int vehicleId;
    @Basic
    @Column(name = "vehicle_name")
    private String vehicleName;
    @Basic
    @Column(name = "vehicle_model")
    private String vehicleModel;
    @Basic
    @Column(name = "year_of_manufacture")
    private int yearOfManufacture;
    @Basic
    @Column(name = "vehicle_color")
    private String vehicleColor;

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
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

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return vehicleId == vehicle.vehicleId && yearOfManufacture == vehicle.yearOfManufacture && Objects.equals(vehicleName, vehicle.vehicleName) && Objects.equals(vehicleModel, vehicle.vehicleModel) && Objects.equals(vehicleColor, vehicle.vehicleColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleId, vehicleName, vehicleModel, yearOfManufacture, vehicleColor);
    }
}
