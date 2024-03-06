package com.T2207E.finaltest.services;

import com.T2207E.finaltest.entities.Vehicle;

import java.util.List;

public interface VehicleService {
    List<Vehicle> getVehicle();
    Vehicle getVehicleId(int id);
    Vehicle createVehicle(Vehicle vehicle);
    Vehicle updateVehicle(int id, Vehicle vehicle);
    void deleteVehicle(int id);
}
