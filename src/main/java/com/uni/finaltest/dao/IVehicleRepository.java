package com.uni.finaltest.dao;

import com.uni.finaltest.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVehicleRepository extends JpaRepository<Vehicle,Integer> {
}
