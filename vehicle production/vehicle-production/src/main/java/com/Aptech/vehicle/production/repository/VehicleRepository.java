package com.Aptech.vehicle.production.repository;

import com.Aptech.vehicle.production.Entiry.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
}
