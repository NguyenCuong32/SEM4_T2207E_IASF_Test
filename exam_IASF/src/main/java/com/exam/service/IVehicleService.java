package com.exam.service;

import com.exam.entity.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public interface IVehicleService {
    List<Vehicle> getAllStudent();

    void addNewVehicle(Vehicle vehicle);

    Optional<Vehicle> findVehicleById (Integer id);

    void updateVehicle(Integer id, Vehicle vehicle);

    void deleteVehicle(Integer id);

}

}
