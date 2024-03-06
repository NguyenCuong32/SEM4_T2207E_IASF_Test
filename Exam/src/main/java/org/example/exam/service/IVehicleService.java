package org.example.exam.service;

import org.example.exam.entity.Vehicle;

import java.util.List;
import java.util.Optional;

public interface IVehicleService {
    public List<Vehicle> getAllVehicles();
    public Optional<Vehicle> getVehicleById(int id);
    public void save(Vehicle vehicle);
    public void update(Vehicle vehicle, int id);
    public void deleteById(int id);
}
