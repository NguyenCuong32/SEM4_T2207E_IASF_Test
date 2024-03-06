package com.hdquoc.exam_2.service;

import com.hdquoc.exam_2.dao.IVehicleRepository;
import com.hdquoc.exam_2.entity.Vehicle;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class VehicleService implements IVehicleService{

    private final IVehicleRepository vehicleRepository;

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
    public void createVehicle(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }

    @Override
    public void updateVehicle(Integer id, Vehicle vehicle) {
        Optional<Vehicle> existedVehicle = vehicleRepository.findById(id);
        if(existedVehicle.isPresent()) {
            Vehicle vehicle1 = existedVehicle.get();
            vehicle1.setVehicle_name(vehicle.getVehicle_name());
            vehicle1.setVehicle_model(vehicle.getVehicle_model());
            vehicle1.setYear_of_manufacture(vehicle.getYear_of_manufacture());
            vehicle1.setVehicle_color(vehicle.getVehicle_color());
            vehicleRepository.save(vehicle1);
        }
        else {
            vehicle.setVehicle_id(id);
            vehicleRepository.save(vehicle);
        }
    }

    @Override
    public void deleteVehicle(Integer id) {
        vehicleRepository.deleteById(id);
    }
}
