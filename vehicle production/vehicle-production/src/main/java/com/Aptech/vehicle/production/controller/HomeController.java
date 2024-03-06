package com.Aptech.vehicle.production.controller;

import com.Aptech.vehicle.production.service.VehicleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    private final VehicleService vehicleService;

    public HomeController(VehicleService vehicleService){this.vehicleService = vehicleService;}

    @GetMapping("/")
    public String Index(Model model){return "vehicle/index";}
}
