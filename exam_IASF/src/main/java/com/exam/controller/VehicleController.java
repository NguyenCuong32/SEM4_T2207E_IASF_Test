package com.exam.controller;

import ch.qos.logback.core.model.Model;
import com.exam.entity.Vehicle;
import com.exam.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1/vehicle")

public class VehicleController {
        private final IVehicleService vehicleService;

        @Autowired
        public VehicleController(IVehicleService vehicleService) {
            this.vehicleService = vehicleService;
        }


        @GetMapping("")
        public String getProducts(Model model) {

            Iterable<Vehicle> students = vehicleService.getAllVehicle();
            model.addAttribute("vehicle", vehicles);
            return "student/index";
        }

    }