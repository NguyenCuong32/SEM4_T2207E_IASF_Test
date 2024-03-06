package com.example.rematch.service;

import com.example.rematch.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    List<Employee> getAllEmployee();
    Optional<Employee> getEmployeeById(String employeeId);
    void addNewEmployee(Employee employee);
    void updateEmployee();
    void deleteEmployee(String employeeId);
}
