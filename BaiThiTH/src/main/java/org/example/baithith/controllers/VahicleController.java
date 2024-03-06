package org.example.baithith.controllers;

import lombok.RequiredArgsConstructor;
import org.example.baithith.models.Vehicle;
import org.example.baithith.services.VehicleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class VahicleController {
    private final VehicleService vehicleService;
    @GetMapping("/vehicle")
    public String showVehicle(Model model) {
        model.addAttribute("vehicle", new Vehicle());
        List<Vehicle> vehicleList = vehicleService.getAllVehicle();
        model.addAttribute("vehicleList",vehicleList);
        return "vehicle/listVehicle";
    }

    @PostMapping("/addVehicle")
    public String addVehicle(@ModelAttribute("vehicle") Vehicle vehicle) {
        vehicleService.saveVehicle(vehicle);
        return "redirect:/vehicle";
    }
    @GetMapping("/deleteVehicle/{id}")
    public String removeEmployee(@PathVariable Long id){
        vehicleService.deleteVehicle(id);
        return "redirect:/employee";
    }
}
