package com.example.prac.service;

import com.example.prac.entities.Ventity;
import com.example.prac.repository.Vrepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Vservice implements IService{
    private final Vrepository vrepository;

    public Vservice(Vrepository vrepository) {
        this.vrepository = vrepository;
    }

    @Override
    public List<Ventity> getAllStudents() {
        return vrepository.findAll();
    }

    @Override
    public Optional<Ventity> getStudentById(String id) {
        return vrepository.findById(id);
    }

    @Override
    @Transactional
    public void addNewStudent(Ventity ventity) {
        ventity.save(ventity);
    }

    @Override
    public void updateStudent() {

    }

    @Override
    public void deleteStudent(String id) {
        vrepository.deleteById(id);
    }
}
