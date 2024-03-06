package com.example.TestIASF.service;

import com.example.TestIASF.model.Vehicle;

import java.util.List;
import java.util.Optional;

public interface IVehicleService {
    List<Vehicle> getAllVehicle();

    Optional<Vehicle> getVehicleById(Integer id);

    void save(Vehicle vehicle);

    void delete(Integer id);
}
