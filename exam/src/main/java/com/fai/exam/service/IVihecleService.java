package com.fai.exam.service;

import com.fai.exam.entity.Vehicle;

import java.util.List;
import java.util.Optional;

public interface IVihecleService {
    List<Vehicle> getAllVehicle();
    Optional<Vehicle> getVehicleById(Integer vehicle_id);
    void saveVehicle(Vehicle vehicle);
    void deleteVehicle(Integer vehicle_id);
}
