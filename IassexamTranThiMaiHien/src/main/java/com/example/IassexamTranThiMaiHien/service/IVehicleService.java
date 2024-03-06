package com.example.IassexamTranThiMaiHien.service;

import com.example.IassexamTranThiMaiHien.entity.Vehicle;

import java.util.List;
import java.util.Optional;

public interface IVehicleService {
    List<Vehicle> getAllVehicle();
    Optional<Vehicle> getVehicleById(Integer id);
    void save(Vehicle vehicle);
    void delete(Integer id);
}
