package com.example.TestIASF.repository;

import com.example.TestIASF.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVehicleRepository extends JpaRepository<Vehicle, Integer> {
}
