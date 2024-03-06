package com.example.IassexamTranThiMaiHien.service;

import com.example.IassexamTranThiMaiHien.dao.IVehicleReponsitory;
import com.example.IassexamTranThiMaiHien.entity.Vehicle;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VehicleService implements IVehicleService {
    private final IVehicleReponsitory vehicleReponsitory;
    @Override
    public List<Vehicle> getAllVehicle() {
        return vehicleReponsitory.findAll();
    }

    @Override
    public Optional<Vehicle> getVehicleById(Integer id) {
        return vehicleReponsitory.findById(id);
    }

    @Override
    public void save(Vehicle vehicle) {
        vehicleReponsitory.save(vehicle);
    }

    @Override
    public void delete(Integer id) {
        vehicleReponsitory.deleteById(id);
    }


}
