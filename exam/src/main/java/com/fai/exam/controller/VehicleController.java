package com.fai.exam.controller;

import com.fai.exam.entity.Vehicle;
import com.fai.exam.service.VehicleService;
import jakarta.validation.Valid;
import lombok.Getter;
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

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("list")
    public String Index(Model model){
        List<Vehicle> vehicleList= vehicleService.getAllVehicle();
        model.addAttribute("vehicleList", vehicleList);
        return "vehicle/index";
    }

    @GetMapping("create")
    public String CreateNewVehicle(Model model){
        Vehicle vehicle= new Vehicle();
        model.addAttribute("vehicle", vehicle);
        return "vehicle/create";
    }

    @PostMapping("save")
    public String SaveVehicle(@Valid @ModelAttribute Vehicle vehicle, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "vehicle/create";
        }
        vehicleService.saveVehicle(vehicle);
        return "redirect:list";
    }

    @GetMapping("update")
    public String UpdateVehicle(Model model, @RequestParam("vehicle_id") Integer vehicle_id){
        Optional<Vehicle> vehicle = vehicleService.getVehicleById(vehicle_id);
        model.addAttribute("vehicle",vehicle);
        return "vehicle/update";
    }

    @GetMapping("delete")
    public String DeleteVehicle(Model model, @RequestParam("vehicle_id") Integer vehicle_id){
        vehicleService.getVehicleById(vehicle_id);
        return "redirect:list";
    }
}
