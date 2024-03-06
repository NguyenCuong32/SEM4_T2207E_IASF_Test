package com.example.ExamIASF.Service;

import com.example.ExamIASF.DAO.IRepo;
import com.example.ExamIASF.Entity.vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class vehicleService implements ivehicleService{

@Autowired
 private    IRepo iRepo;

    @Override
    public List<vehicle> getAll(){
        return iRepo.findAll();
    }
    @Override
    public boolean create(vehicle vehicles){
        try{
            this.iRepo.save(vehicles);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public vehicle findbyID(Integer id){
        return this.iRepo.findById(id).get();
    }
    @Override
    public   boolean update(vehicle vehicles){
        try{
            this.iRepo.save(vehicles);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public   boolean delete(Integer id){
        try{
            this.iRepo.delete(findbyID(id));
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
