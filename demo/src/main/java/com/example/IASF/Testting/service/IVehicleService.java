package com.example.IASF.Testting.service;

import com.example.IASF.Testting.entity.vehicle;

import java.util.List;

public interface IVehicleService {
    List<vehicle> findAllVehicle();

    void add(vehicle vehicle);

}
