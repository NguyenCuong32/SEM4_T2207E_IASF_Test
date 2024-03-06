package com.uni.finaltest.controllers;

import com.uni.finaltest.entity.Vehicle;
import com.uni.finaltest.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class MonitorController {
    private final VehicleService vehicleService;
    @Autowired
    public MonitorController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/list")
    public String Catalogue(Model model){
        var vehicles = vehicleService.getEveryVehicles();
        model.addAttribute("vehicles", vehicles);
        return "monitor";
    }
    @PostMapping("/save")
    public String Save (@ModelAttribute("vehicle") Vehicle vehicle){
        vehicleService.save(vehicle);
        return "redirect:/list";
    }
    @GetMapping("formUpdate")
    public String ShowFormUpdate(@RequestParam("vehicleId") Integer id, Model model) {
        Optional<Vehicle> student = vehicleService.getVehicleById(id);
        model.addAttribute("vehicle", vehicle);
        return "addNew";
    }
    @GetMapping("delete")
    public String DeleteVehicle(@RequestParam("vehicleId") Integer id, Model model) {
        vehicleService.deleteVehicle(id);
        return "redirect:/list";
    }
}
