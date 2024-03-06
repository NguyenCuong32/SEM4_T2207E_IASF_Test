package com.T2207E.finaltest.controllers;

import com.T2207E.finaltest.entities.Vehicle;
import com.T2207E.finaltest.services.VehicleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/vehicle")
public class VehicleController {
    private final VehicleService vehicleService;

    @GetMapping("/list")
    public String listVehicle(Model model){
        List<Vehicle> vehicles = vehicleService.getVehicle();
        model.addAttribute("vehicles",vehicles);
        return "pages/vehicles/ListVehicles";
    }
    @GetMapping("/add")
    public String addVehicle(Model model){
        Vehicle vehicle = new Vehicle();
        model.addAttribute("vehicle",vehicle);
        return "pages/vehicles/AddVehicles";
    }

    @PostMapping("/save")
    public String saveVehicle(@ModelAttribute("vehicle") @Valid Vehicle vehicle, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            // Có lỗi validation, xử lý thông báo lỗi
            return "pages/vehicles/AddVehicles";
        }
        vehicleService.createVehicle(vehicle);
        return "redirect:/admin/vehicle/list";
    }

    @GetMapping("/edit")
    public String editVehicle(@RequestParam("id")int id, Model model){
        Vehicle vehicle = vehicleService.getVehicleId(id);
        model.addAttribute("vehicle",vehicle);
        return "pages/vehicles/UpdateVehicles";
    }

    @PostMapping("/update")
    public String updateVehicle(@RequestParam("id")int id, @ModelAttribute("vehicle") @Valid Vehicle vehicle, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            // Có lỗi validation, xử lý thông báo lỗi
            return "pages/vehicles/UpdateVehicles";
        }
        vehicleService.updateVehicle(id, vehicle);
        return "redirect:/admin/vehicle/list";
    }

    @DeleteMapping("/delete")
    public String deleteVehicle(@RequestParam("id")int id){
        vehicleService.deleteVehicle(id);
        return "redirect:/admin/vehicle/list";
    }
}
