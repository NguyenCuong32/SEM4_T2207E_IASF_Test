package com.Aptech.vehicle.production.service;

import com.Aptech.vehicle.production.Entiry.Vehicle;

import java.util.List;
import java.util.Optional;

public interface IVehicleService {
    List<Vehicle> getAllVehicle();
    Optional<Vehicle> getVehicleById(int id);
    void save(Vehicle vehicle);
    void deleteById(Integer id);
}
