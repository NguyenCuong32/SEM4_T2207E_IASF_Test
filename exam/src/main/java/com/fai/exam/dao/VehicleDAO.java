package com.fai.exam.dao;

import com.fai.exam.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleDAO extends JpaRepository<Vehicle,Integer> {

}
