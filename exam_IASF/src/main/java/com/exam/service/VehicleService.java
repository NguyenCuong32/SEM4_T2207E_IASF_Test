package com.exam.service;

import com.exam.dao.IVehicleRepository;
import com.exam.entity.Vehicle;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component

public class VehicleService implements IVehicleService {
    private final IVehicleService vehicleRepository;

    @Autowired
    public IVehicleService(IVehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<Vehicle> getAllStudent() {
        return vehicleRepository.findAll();
    }

    @Override
    @Transactional
    public void addNewVehicle(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }

    @Override
    public Optional<Vehicle> findVehicleById(Integer id) {
        return vehicleRepository.findVehicleById(id);
    }

    @Override
    @Transactional
    public void updateVehicle(Integer id, Vehicle vehicle) {
        Optional<Vehicle> existedStudent = vehicleRepository.findById(id);
        if(existedStudent.isPresent()){
            Vehicle newVehicle = existedVehicle.get();
            newVehicle.setvehicle_name(vehicle.getvehicle_name());
            newVehicle.setvehical_model(vehicle.getvehicle_model());
            newVehicle.setyear_of_manufacture(vehicle.getsetyear_of_manufacture());
            newVehicle.setvehicle_color(vehicle.getvehicle_color());
            vehicleRepository.save(newVehicle);
        } else {
            vehicle.setId(id);
            vehicleRepository.save(vehicle);
        }
    }

    @Override
    @Transactional
    public void deleteStudent(Integer id) {
        vehicleRepositoryRepository.deleteById(id);
    }

}