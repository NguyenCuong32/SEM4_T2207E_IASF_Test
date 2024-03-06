package com.fai.exam.Controller;

import com.fai.exam.entity.vehicle;
import com.fai.exam.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleController {

    private final IVehicleService vehicleService;
    @Autowired
    public VehicleController(IVehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/listVehicle")
    public String getAllVehicle(Model model){
        List<vehicle> vehicleList = vehicleService.getAllVehicle();
        model.addAttribute("vehicleList", vehicleList);
        return "vehicle/index";
    }
    @PostMapping("saveVehicle")
    public String addNewVehicle(@ModelAttribute("Vehicle")vehicle aVehicle){
        vehicleService.addNewVehicle(aVehicle);
        return "redirect:vehicle/index";
    }
    @GetMapping("/addNewVehicle")
    public String addNewVehicle(@RequestParam("VehicleId")String id, Model model){
        Optional<vehicle> vehicleList = vehicleService.getByIdVehicle(id);
        model.addAttribute("vehicleList",vehicleList);
        return "vehicle/addNew";
    }
}

