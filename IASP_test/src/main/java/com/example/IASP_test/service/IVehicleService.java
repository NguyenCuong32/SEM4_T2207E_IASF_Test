package com.example.IASP_test.service;

import com.example.IASP_test.entity.Vehicle;

import java.util.List;

public interface IVehicleService {
    public Vehicle addVehicle(Vehicle vehicle);
    public Vehicle updateVehicle(Integer vehicle_id, Vehicle vehicle);
    public boolean deleteVehicle(Integer vehicle_id);
    public List<Vehicle> getAllVehicle();

}
