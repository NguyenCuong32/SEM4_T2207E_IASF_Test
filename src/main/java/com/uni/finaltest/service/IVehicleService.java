package com.uni.finaltest.service;

import com.uni.finaltest.entity.Vehicle;

import java.util.List;
import java.util.Optional;

public interface IVehicleService {
    List<Vehicle> getEveryVehicles();
    Optional<Vehicle> getVehicleById(int id);
    void save(Vehicle vehicle);
    void updateVehicle();
    void deleteVehicle(int id);
}
