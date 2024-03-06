package com.example.TestIASF.service;

import com.example.TestIASF.model.Vehicle;
import com.example.TestIASF.repository.IVehicleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService implements IVehicleService{
    private final IVehicleRepository vehicleRepository;
    @Autowired
    public VehicleService(IVehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }


    @Override
    public List<Vehicle> getAllVehicle() {
        return vehicleRepository.findAll();
    }

    @Override
    public Optional<Vehicle> getVehicleById(Integer id) {
        return vehicleRepository.findById(id);
    }

    @Override
    @Transactional
    public void save(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        vehicleRepository.deleteById(id);
    }
}
