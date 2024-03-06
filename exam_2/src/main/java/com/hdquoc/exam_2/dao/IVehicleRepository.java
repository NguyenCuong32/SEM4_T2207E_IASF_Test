package com.hdquoc.exam_2.dao;

import com.hdquoc.exam_2.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVehicleRepository extends JpaRepository<Vehicle, Integer> {
}
