package com.example.IASP_test.controller;

import com.example.IASP_test.entity.Vehicle;
import com.example.IASP_test.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/vehicle")

public class VehicleController {
    private IVehicleService vehicleService;
    @Autowired
    public VehicleController(IVehicleService vehicleService){
        this.vehicleService = vehicleService;
    }
    @GetMapping("")
    public String Index(Model model){
        List<Vehicle> vehicles = vehicleService.getAllVehicle();
        model.addAttribute("vehicles", vehicles)
        return "vehilce";
    }
    @PostMapping("save")
    public String addVehicle(@ModelAttribute("vehicles")Vehicle vehicle){
        vehicleService.addVehicle(vehicle);
        return "redirec:/vehicle";
    }
}
