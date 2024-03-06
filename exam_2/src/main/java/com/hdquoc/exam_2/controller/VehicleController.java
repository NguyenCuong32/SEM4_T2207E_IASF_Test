package com.hdquoc.exam_2.controller;

import com.hdquoc.exam_2.entity.Vehicle;
import com.hdquoc.exam_2.service.IVehicleService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/v1/vehicle")
public class VehicleController {

    private final IVehicleService vehicleService;

    public VehicleController(IVehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("")
    public String getVehicles(Model model) {
        Iterable<Vehicle> vehicles = vehicleService.getAllVehicle();
        model.addAttribute("vehicles", vehicles);
        return "vehicle/index";
    }

    @GetMapping("/add")
    public String getFormVehicle(Model model){
        model.addAttribute("newVehicle", new Vehicle());
        return "vehicle/add";
    }

    @PostMapping("/add")
    public String saveVehicle(@Valid @ModelAttribute("newVehicle") Vehicle newVehicle, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "vehicle/add";
        } else {
            vehicleService.createVehicle(newVehicle);
            return "redirect:/v1/vehicles";
        }
    }

}
