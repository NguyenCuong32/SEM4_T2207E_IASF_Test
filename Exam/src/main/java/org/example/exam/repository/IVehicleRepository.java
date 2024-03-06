package org.example.exam.repository;

import org.example.exam.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVehicleRepository extends JpaRepository<Vehicle, Integer> {
}
