package com.uni.finaltest.service;

import com.uni.finaltest.dao.IVehicleRepository;
import com.uni.finaltest.entity.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class VehicleService implements IVehicleService {

    private final IVehicleRepository vehicleRepository;

    public VehicleService(IVehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<Vehicle> getEveryVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public Optional<Vehicle> getVehicleById(int id) {
        return vehicleRepository.findById(id);
    }

    @Override
    public void save(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }

    @Override
    public void updateVehicle() {

    }

    @Override
    public void deleteVehicle(int id) {
        vehicleRepository.deleteById(id);
    }
}
