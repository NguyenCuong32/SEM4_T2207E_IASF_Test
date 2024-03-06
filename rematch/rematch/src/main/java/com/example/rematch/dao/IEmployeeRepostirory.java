package com.example.rematch.dao;

import com.example.rematch.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepostirory extends JpaRepository<Employee,String> {

}