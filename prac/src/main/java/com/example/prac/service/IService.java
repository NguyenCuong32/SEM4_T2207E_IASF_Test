package com.example.prac.service;

import com.example.prac.entities.Ventity;

import java.util.List;
import java.util.Optional;

public interface IService {
    List<Ventity> getAllStudents();
    Optional<Ventity> getStudentById(String vehicle_id);
    void addNewStudent(Ventity ventity);
    void updateStudent();
    void deleteStudent(String vehicle_id);
}
