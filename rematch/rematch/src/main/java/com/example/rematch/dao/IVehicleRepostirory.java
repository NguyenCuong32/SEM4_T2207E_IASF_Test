package com.example.rematch.dao;

import com.example.rematch.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVehicleRepostirory extends JpaRepository<Vehicle,Integer> {

}