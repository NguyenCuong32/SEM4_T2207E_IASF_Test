package com.example.IASF.Testting.repository;

import com.example.IASF.Testting.entity.vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<vehicle,Integer> {
}
