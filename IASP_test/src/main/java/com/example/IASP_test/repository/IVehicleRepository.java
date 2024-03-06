package com.example.IASP_test.repository;

import com.example.IASP_test.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IVehicleRepository extends JpaRepository<Vehicle, Integer> {
}
