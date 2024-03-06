package com.exam.dao;

import com.exam.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVehicleRepository extends JpaRepository<Vehicle,Integer> {
}
