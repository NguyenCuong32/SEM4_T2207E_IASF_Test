package com.example.IASF.Testting.ViewController;

import com.example.IASF.Testting.entity.vehicle;
import com.example.IASF.Testting.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class VehicleController {

    @Autowired
    IVehicleService vehicleService;

    @GetMapping("/vehical")
    public String ListVehicle(Model model){
      List<vehicle> vehicles = vehicleService.findAllVehicle();
        model.addAttribute("vehicals", vehicles);
        return "Vehical";
    }

    @PostMapping("/vehical")
    public String addVehical(@RequestParam("vehicleName") String vehicleName,
                             @RequestParam("vehicleModel") String vehicleModel,
                             @RequestParam("yearOfManufacture") int yearOfManufacture,
                             @RequestParam("vehicleColor") String vehicleColor,
                             Model model){
        try {
            vehicle newVehicle = new vehicle();
            newVehicle.setVehicle_name(vehicleName);
            newVehicle.setVehicle_model(vehicleModel);
            newVehicle.setYear_of_manufacture(yearOfManufacture);
            newVehicle.setVehicle_color(vehicleColor);
            vehicleService.add(newVehicle);
            return "redirect:/vehical";
        }catch (Exception ex){
            model.addAttribute("errorMessage", "An error occurred while saving the vehicle: " + ex.getMessage());
            return "redirect:/vehical";
        }
    }

}
