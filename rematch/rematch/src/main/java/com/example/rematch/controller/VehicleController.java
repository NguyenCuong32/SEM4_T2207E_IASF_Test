package com.example.rematch.controller;

import com.example.rematch.entity.Vehicle;
import com.example.rematch.service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/vehicle")
public class VehicleController {
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {

        this.vehicleService = vehicleService;
    }
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }
    @GetMapping("/list")
    public String GetStudents(Model model) {
        List<Vehicle> vehicles = vehicleService.getAllVehicle();
        model.addAttribute("vehicles", vehicles);
        return "vehicle/index";
    }

    @GetMapping("/formAdd")
    public String ShowFormAdd(Model model) {
        Vehicle vehicle = new Vehicle();
        model.addAttribute("vehicle", vehicle);
        return "vehicle/addNew";
    }

    @PostMapping("/save")
    public String SaveStudent(@Valid @ModelAttribute("vehicle") Vehicle vehicle, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "vehicle/addNew";
        } else {
            vehicleService.addNewVehicle(vehicle);
            return "redirect:/vehicle/list";
        }
    }

    @GetMapping("formUpdate")
    public String ShowFormUpdate(@RequestParam("vehicleId") Integer vehicleId, Model model) {
        Optional<Vehicle> vehicle = vehicleService.getVehicleById(vehicleId);
        model.addAttribute("vehicle", vehicle);
        return "vehicle/addNew";
    }
    @GetMapping("delete")
    public String DeleteStudent(@RequestParam("vehicleId") Integer vehicleId, Model model){
        vehicleService.deleteEmployee(vehicleId);
        return "redirect:/vehicle/list";
    }
}