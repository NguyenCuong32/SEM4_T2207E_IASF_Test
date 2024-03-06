package com.fai.exam.service;

import com.fai.exam.entity.vehicle;
import com.fai.exam.repository.IVehicleRepository;
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
    public List<vehicle> getAllVehicle() {
        return vehicleRepository.findAll();
    }

    @Override
    public Optional<vehicle> getByIdVehicle(String id) {
        return vehicleRepository.findById(id);
    }

    @Override
    public void addNewVehicle(vehicle aVehicle) {
        vehicleRepository.save(aVehicle);
    }
}
