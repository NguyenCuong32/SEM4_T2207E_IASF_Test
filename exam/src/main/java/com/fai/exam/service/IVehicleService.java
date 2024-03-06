package com.fai.exam.service;

import com.fai.exam.entity.vehicle;

import java.util.List;
import java.util.Optional;

public interface IVehicleService {
    List<vehicle> getAllVehicle();
    Optional<vehicle> getByIdVehicle(String id);
    void addNewVehicle(vehicle aVehicle);
}