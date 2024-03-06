package com.example.IassexamTranThiMaiHien.controller;

import com.example.IassexamTranThiMaiHien.entity.Vehicle;
import com.example.IassexamTranThiMaiHien.service.VehicleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("vehicle")
public class VehicleController {
    private final VehicleService vehicleService;
    @GetMapping("list")
    public String Index(Model model){
        List<Vehicle> vehicleList=vehicleService.getAllVehicle();
        model.addAttribute("vehicleList",vehicleList);
        return "vehicle/index";
    }
    @GetMapping("create")
    public String CreateVehicle(Model model){
        List<Vehicle> vehicles=vehicleService.getAllVehicle();
        Vehicle vehicle=new Vehicle();
        model.addAttribute("vehicle",vehicle);

        return "vehicle/create";
    }
    @PostMapping("save")
    public String Savevehicle(@Valid @ModelAttribute Vehicle vehicle, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "vehicle/create";
        }
        vehicleService.save(vehicle);
        return "redirect:list";
    }
    @GetMapping("update")
    public String Updatevehicle(Model model, @RequestParam("vehicle_id") Integer vehicle_id){
        Optional<Vehicle> vehicle=vehicleService.getVehicleById(vehicle_id);
        model.addAttribute("vehicle",vehicle);
        return "vehicle/update";
    }
    @GetMapping("delete")
    public String Deletevehicle(Model model,@RequestParam("id")Integer id) {
        vehicleService.delete(id);
        return "redirect:list";

    }}
