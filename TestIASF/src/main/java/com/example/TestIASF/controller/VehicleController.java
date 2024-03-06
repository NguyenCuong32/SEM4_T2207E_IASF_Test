package com.example.TestIASF.controller;

import com.example.TestIASF.entity.Vehicle;
import com.example.TestIASF.service.VehicleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("vehicle")
public class VehicleController {
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("list")
    public String List(Model model){
        List<Vehicle> vehicles = vehicleService.getAllVehicle();
        model.addAttribute("vehicles",vehicles);
        return "Vehicle/index";
    }

    @GetMapping("addForm")
    public String addForm(Model model){
        Vehicle vehicle = new Vehicle();
        model.addAttribute("vehicle", vehicle);
        return "Vehicle/add";
    }

    @PostMapping("save")
    public String Save(@ModelAttribute Vehicle vehicle){
        vehicleService.save(vehicle);
        return "redirect:/vehicle/list";
    }

    @GetMapping("editForm/{id}")
    public String editForm(@PathVariable int id, Model model){
        Optional<Vehicle> vehicleOptional = vehicleService.getVehicleById(id);
        if(vehicleOptional.isPresent()){
            Vehicle vehicle = vehicleOptional.get();
            model.addAttribute("vehicle", vehicle);
            return "Vehicle/edit";
        }
        return "redirect:vehicle/list";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id){
        vehicleService.delete(id);
        return "redirect:/vehicle/list";
    }
}
