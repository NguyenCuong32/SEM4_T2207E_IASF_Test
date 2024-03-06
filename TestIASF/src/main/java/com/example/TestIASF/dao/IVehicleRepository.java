package com.example.TestIASF.dao;

import com.example.TestIASF.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVehicleRepository extends JpaRepository<Vehicle, Integer> {
}
