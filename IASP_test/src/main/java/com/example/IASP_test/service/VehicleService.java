package com.example.IASP_test.service;

import com.example.IASP_test.entity.Vehicle;
import com.example.IASP_test.repository.IVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class VehicleService implements IVehicleService{
    private IVehicleRepository vehicleRepository;
    @Autowired
    public VehicleService(IVehicleRepository vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
            return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle updateVehicle(Integer vehicle_id, Vehicle vehicle) {
        return null;
    }

    @Override
    public boolean deleteVehicle(Integer vehicle_id) {
        vehicleRepository.deleteById(vehicle_id);
        return true;
    }

    @Override
    public List<Vehicle> getAllVehicle() {
        return vehicleRepository.findAll();
    }
}
