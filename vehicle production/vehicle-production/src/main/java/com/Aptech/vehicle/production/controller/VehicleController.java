package com.Aptech.vehicle.production.controller;

import com.Aptech.vehicle.production.Entiry.Vehicle;
import com.Aptech.vehicle.production.service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "vehicle")
public class VehicleController {
    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService){
        this.vehicleService = vehicleService;
    }

    @InitBinder
    public void initbinder(WebDataBinder webDataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    @GetMapping("/list")
    public String GetListVehicles(Model model){
        List<Vehicle> vehicles = vehicleService.getAllVehicle();
        model.addAttribute("vehicle",vehicles);
        return "vehicle/index";
    }

    @GetMapping("/add")
    public String CreateVehicle(Model model){
        Vehicle vehicle = new Vehicle();
        model.addAttribute("vehicle",vehicle);
        return "vehicle/add";
    }

    @PostMapping("/add")
    public String AddVehicle(@Valid @ModelAttribute Vehicle vehicle, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "vehicle/add";
        }else {
            vehicleService.save(vehicle);
            return "redirect:/vehicle/list";
        }
    }

    @GetMapping("/editForm/{id}")
    public String ViewEditVehicle(@PathVariable Integer id, Model model){
        Optional<Vehicle> vehicle = vehicleService.getVehicleById(id);
        model.addAttribute("vehicle", vehicle);
        return "vehicle/edit";
    }

    @PostMapping("/edit")
    public String editVehicle(@ModelAttribute Vehicle vehicle){
        vehicleService.save(vehicle);
        return "redirect:/vehicle/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteVehicle(@PathVariable Integer id){
        vehicleService.deleteById(id);
        return "redirect:/vehicle/list";
    }
}
