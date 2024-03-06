package com.example.rematch.service;

import com.example.rematch.dao.IEmployeeRepostirory;
import com.example.rematch.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    private final IEmployeeRepostirory employeeRepostirory;
    @Autowired
    public EmployeeService(IEmployeeRepostirory employeeRepostirory) {
        this.employeeRepostirory = employeeRepostirory;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepostirory.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(String employeeId) {
        return employeeRepostirory.findById(employeeId);
    }

    @Override
    @Transactional
    public void addNewEmployee(Employee employee) {
        employeeRepostirory.save(employee);
    }

    @Override
    public void updateEmployee() {
    }
    @Override
    public void deleteEmployee(String employeeId) {
        employeeRepostirory.deleteById(employeeId);
    }
}
