package com.fai.exam.service;

import com.fai.exam.dao.VehicleDAO;
import com.fai.exam.entity.Vehicle;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

public class VehicleService implements IVihecleService{

    private final VehicleDAO vehicleDAO;

    public VehicleService(VehicleDAO vehicleDAO) {
        this.vehicleDAO = vehicleDAO;
    }

    @Override
    public List<Vehicle> getAllVehicle() {
        return vehicleDAO.findAll();
    }

    @Override
    public Optional<Vehicle> getVehicleById(Integer vehicle_id) {
        return vehicleDAO.findById(vehicle_id);
    }

    @Override
    public void saveVehicle(Vehicle vehicle) {
        vehicleDAO.save(vehicle);
    }

    @Override
    public void deleteVehicle(Integer vehicle_id) {
        vehicleDAO.deleteById(vehicle_id);
    }
}
