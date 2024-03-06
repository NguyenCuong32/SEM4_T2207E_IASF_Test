package com.example.exam.service;

import com.example.exam.entity.Vehicle;
import com.example.exam.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public List<Vehicle> getAllVehicle() {
        return vehicleRepository.findAll();
    }
}
