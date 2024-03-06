package com.fai.exam.repository;

import com.fai.exam.entity.vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVehicleRepository extends JpaRepository<vehicle,String> {
}
