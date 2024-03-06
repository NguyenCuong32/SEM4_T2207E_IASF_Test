package com.example.rematch.service;

import com.example.rematch.entity.Vehicle;

import java.util.List;
import java.util.Optional;

public interface IVehicleService {
    List<Vehicle> getAllVehicle();
    Optional<Vehicle> getVehicleById(Integer vehicleId);


    void addNewVehicle(Vehicle vehicle);
    void updateVehicle();
    void deleteEmployee(Integer vehicleId);
}
