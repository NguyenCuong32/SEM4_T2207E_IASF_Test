package com.example.TestIASF.controller;

import com.example.TestIASF.model.Vehicle;
import com.example.TestIASF.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("vehicle")
public class VehicleController {
    private final VehicleService vehicleService;
    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("list")
    public String list(Model model){
        List<Vehicle> vehicles = vehicleService.getAllVehicle();
        model.addAttribute("vehicles", vehicles);
        return "Vehicle/index";
    }

    @GetMapping("formAdd")
    public String addForm(Model model){
        Vehicle vehicle = new Vehicle();
        model.addAttribute("vehicle", vehicle);
        return "Vehicle/add";
    }

    @PostMapping("save")
    public String save(@ModelAttribute Vehicle vehicle){
        vehicleService.save(vehicle);
        return "redirect:/vehicle/list";
    }

    @GetMapping("formEdit/{id}")
    public String editForm(@PathVariable Integer id, Model model){
        Optional<Vehicle> vehicleOptional = vehicleService.getVehicleById(id);
        if(vehicleOptional.isPresent()) {
            Vehicle vehicle = vehicleOptional.get();
            model.addAttribute("vehicle", vehicle);
            return "Vehicle/edit";
        }
        return "redirect:/vehicle/list";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable Integer id){
        vehicleService.delete(id);
        return "redirect:/vehicle/list";
    }
}
