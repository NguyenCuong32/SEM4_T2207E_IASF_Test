package com.example.ExamIASF.Service;

import com.example.ExamIASF.Entity.vehicle;

import java.util.List;

public interface ivehicleService {
    public List<vehicle> getAll();
    boolean create(vehicle vehicles);
    vehicle findbyID(Integer id);
    boolean update(vehicle vehicle);

    public boolean delete(Integer id);

}
