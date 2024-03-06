package com.T2207E.finaltest.services;

import com.T2207E.finaltest.entities.Vehicle;
import com.T2207E.finaltest.repositories.VehicleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VehicleServiceImple implements VehicleService{

    private final VehicleRepository vehicleRepository;


    @Override
    public List<Vehicle> getVehicle() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle getVehicleId(int id) {
        Optional<Vehicle> getVehicle = vehicleRepository.findById(id);
        return getVehicle.get();
    }

    @Override
    @Transactional
    public Vehicle createVehicle(Vehicle vehicle) {
        Vehicle setVehicle = new Vehicle();
        setVehicle.setVehicleName(vehicle.getVehicleName());
        setVehicle.setVehicleModel(vehicle.getVehicleModel());
        setVehicle.setYearOfManuFacture(vehicle.getYearOfManuFacture());
        setVehicle.setVehicleColor(vehicle.getVehicleColor());
        return vehicleRepository.save(setVehicle);
    }

    @Override
    @Transactional
    public Vehicle updateVehicle(int id, Vehicle vehicle) {
        Vehicle setVehicle = getVehicleId(id);
        setVehicle.setVehicleName(vehicle.getVehicleName());
        setVehicle.setVehicleModel(vehicle.getVehicleModel());
        setVehicle.setYearOfManuFacture(vehicle.getYearOfManuFacture());
        setVehicle.setVehicleColor(vehicle.getVehicleColor());
        return vehicleRepository.saveAndFlush(setVehicle);
    }

    @Override
    public void deleteVehicle(int id) {
        vehicleRepository.deleteById(id);
    }
}
