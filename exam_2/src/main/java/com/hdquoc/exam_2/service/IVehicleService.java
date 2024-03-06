package com.hdquoc.exam_2.service;

import com.hdquoc.exam_2.entity.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IVehicleService {
    List<Vehicle> getAllVehicle();

    Optional<Vehicle> getVehicleById (Integer id);

    void createVehicle(Vehicle vehicle);

    void updateVehicle(Integer id, Vehicle vehicle);

    void deleteVehicle(Integer id);
}
