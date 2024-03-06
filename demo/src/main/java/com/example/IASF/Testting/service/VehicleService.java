package com.example.IASF.Testting.service;

import com.example.IASF.Testting.entity.vehicle;
import com.example.IASF.Testting.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService implements IVehicleService {
    @Autowired
    VehicleRepository vehicleRepository;

    @Override
    public List<vehicle> findAllVehicle() {
        return vehicleRepository.findAll();
    }

    @Override
    public void add(vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }
}
