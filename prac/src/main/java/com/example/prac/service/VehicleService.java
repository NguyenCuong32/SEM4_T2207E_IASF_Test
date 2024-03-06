package com.example.prac.service;

import com.example.prac.entities.Vehicle;
import com.example.prac.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public List<Vehicle> getAllVehicle() {
        return vehicleRepository.findAll();
    }

    public void createVehicle(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }
}