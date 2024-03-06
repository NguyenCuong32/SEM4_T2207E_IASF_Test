package org.example.exam.controller;


import jakarta.validation.Valid;
import org.example.exam.entity.Vehicle;
import org.example.exam.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("vehicles")
public class VehicleController {
    private final VehicleService vehicleService;
    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("list")
    public String getAllVehicles(Model model){
        List<Vehicle> vehicles = vehicleService.getAllVehicles();
        model.addAttribute("vehicles", vehicles);
        return "/Vehicle/indexAdmin";
    }

    @GetMapping("listUser")
    public String getAllVehiclesUser(Model model){
        List<Vehicle> vehicles = vehicleService.getAllVehicles();
        model.addAttribute("vehicles", vehicles);
        return "/Vehicle/indexUser";
    }

    @GetMapping("add")
    public String add(Model model){
        Vehicle vehicle = new Vehicle();
        model.addAttribute("vehicle", vehicle);
        return "/Vehicle/Add";
    }

    @PostMapping("add")
    public String add(@Valid @ModelAttribute("product") Vehicle vehicle, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/Vehicle/Add";
        }
        vehicleService.save(vehicle);
        return "redirect:/vehicles/list";
    }

    @GetMapping("edit")
    public String edit(@RequestParam int id, Model model) {
        Optional<Vehicle> vehicleOptional = vehicleService.getVehicleById(id);
        if (vehicleOptional.isPresent()) {
            model.addAttribute("vehicle",vehicleOptional.get());
            return "/Vehicle/Edit";
        }else {
            return "redirect:/vehicles/list";
        }
    }

    @PostMapping("edit")
    public String edit(@RequestParam int id, @ModelAttribute("vehicle") Vehicle vehicle) {
        vehicleService.update(vehicle, id);
        return "redirect:/vehicles/list";
    }

    @GetMapping("delete")
    public String delete(int id){
        vehicleService.deleteById(id);
        return "redirect:/vehicles/list";
    }
}
