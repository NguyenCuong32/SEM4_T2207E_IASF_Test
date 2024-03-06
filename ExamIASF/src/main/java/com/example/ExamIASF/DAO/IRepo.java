package com.example.ExamIASF.DAO;

import com.example.ExamIASF.Entity.vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepo extends JpaRepository<vehicle, Integer> {

}
