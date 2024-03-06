package com.example.exam.controller;

import com.example.exam.entity.Vehicle;
import com.example.exam.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class HomeController {

    private final VehicleService vehicleService;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("vehicles", vehicleService.getAllVehicle());
        return "index";
    }

    @GetMapping("/add-new")
    public String addNew(Model model) {
        model.addAttribute("vehicle", new Vehicle());
        return "create-form";
    }

    @PostMapping("/add-new")
    public String addNewSavc(
            @ModelAttribute("vehicle") Vehicle vehicle,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            return "/create-form";
        }

        vehicleService.createVehicle(vehicle);
        model.addAttribute("vehicle", new Vehicle());
        return "index";
    }

}
