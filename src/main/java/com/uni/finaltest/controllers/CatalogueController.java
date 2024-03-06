package com.uni.finaltest.controllers;

import com.uni.finaltest.entity.Vehicle;
import com.uni.finaltest.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class CatalogueController {
    private final VehicleService vehicleService;
    @Autowired
    public CatalogueController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }
//    @GetMapping("/list")
//    public String Catalogue(Model model){
//        var vehicles = vehicleService.getEveryVehicles();
//        model.addAttribute("vehicles", vehicles);
//        return "catalog";
//    }
//    @PostMapping("/save")
//    public String Save (@ModelAttribute("vehicle") Vehicle vehicle){
//        vehicleService.save(vehicle);
//        return "redirect:/list";
//    }
}
