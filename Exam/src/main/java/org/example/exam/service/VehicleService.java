package org.example.exam.service;

import org.example.exam.entity.Vehicle;
import org.example.exam.repository.IVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService implements IVehicleService{
    private final IVehicleRepository iVehicleRepository;
    @Autowired
    public VehicleService(IVehicleRepository iVehicleRepository) {
        this.iVehicleRepository = iVehicleRepository;
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return iVehicleRepository.findAll();
    }

    @Override
    public Optional<Vehicle> getVehicleById(int id) {
        return iVehicleRepository.findById(id);
    }

    @Override
    public void save(Vehicle vehicle) {
        iVehicleRepository.save(vehicle);
    }

    @Override
    public void update(Vehicle vehicle, int id) {
        Optional<Vehicle> vehicleOptional = iVehicleRepository.findById(id);
        if(vehicleOptional.isPresent()){
            Vehicle existingVehicleOptional = vehicleOptional.get();
            existingVehicleOptional.setVehicle_name(vehicle.getVehicle_name());
            existingVehicleOptional.setVehicle_model(vehicle.getVehicle_model());
            existingVehicleOptional.setYear_of_manufacture(vehicle.getYear_of_manufacture());
            existingVehicleOptional.setVehicle_color(vehicle.getVehicle_color());
            iVehicleRepository.save(existingVehicleOptional);
        }
    }

    @Override
    public void deleteById(int id) {
        iVehicleRepository.deleteById(id);
    }
}
