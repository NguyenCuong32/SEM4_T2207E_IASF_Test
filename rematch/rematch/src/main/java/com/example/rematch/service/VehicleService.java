package com.example.rematch.service;


import com.example.rematch.dao.IVehicleRepostirory;
import com.example.rematch.entity.Vehicle;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService implements IVehicleService {
    private final IVehicleRepostirory vehicleRepostirory;
    @Autowired
    public VehicleService(IVehicleRepostirory vehicleRepostirory) {
        this.vehicleRepostirory = vehicleRepostirory;
    }

    @Override
    public List<Vehicle> getAllVehicle() {
        return vehicleRepostirory.findAll();
    }

    @Override
    public Optional<Vehicle> getVehicleById(Integer vehicleId) {
        return vehicleRepostirory.findById(vehicleId);
    }

    @Override
    @Transactional
    public void addNewVehicle(Vehicle vehicle) {
        vehicleRepostirory.save(vehicle);
    }

    @Override
    public void updateVehicle() {
    }
    @Override
    public void deleteEmployee(Integer vehicleId) {
        vehicleRepostirory.deleteById(vehicleId);
    }
}
