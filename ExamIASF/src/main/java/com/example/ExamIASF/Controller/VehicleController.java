package com.example.ExamIASF.Controller;

import com.example.ExamIASF.Entity.vehicle;
import com.example.ExamIASF.Service.vehicleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping()
public class VehicleController {
    @Autowired
private vehicleService vehicleService;
    @GetMapping("/dashboard")
    public String index(Model model ){

        List<vehicle> list = this.vehicleService.getAll();

        model.addAttribute("list",list);
        return "Index";
    }

    @GetMapping("/addstd")
    public String add(Model model){
        vehicle vehicles = new vehicle();
        model.addAttribute("vehicle",vehicles);
        return "Vehicle/addform";
    }

    @PostMapping("/addstd")
    public String save(@ModelAttribute("vehicle") vehicle vehicle ) {
        if (this.vehicleService.create(vehicle)) {
            return "redirect:/dashboard";
        } else {
            return "Vehicle/addform";
        }
    }

    @GetMapping("/edit/{id}")
    public String showUpdate(@PathVariable("id") Integer id, Model model)
    {
          vehicle vehicles = vehicleService.findbyID(id);
          model.addAttribute("vehicle", vehicles);
          return "Vehicle/update";
    }

    @PostMapping("/update/{id}")
    public String changeUser(@PathVariable("id") Integer stdId, @Valid vehicle vehicle,
                             BindingResult result, Model model){
        if (result.hasErrors()) {
            vehicle.setVehicle_id(stdId);
            return "Vehicle/update";
        }
        else {
            vehicle.setVehicle_id(stdId); //nếu id là auto increment
            vehicleService.update(vehicle);
            return "redirect:/dashboard";}
    }

    @GetMapping("/del/{id}")
    public String deluser(@PathVariable("id") Integer id, Model model){
        vehicle student = vehicleService.findbyID(id);

        student.setVehicle_id(id);
        vehicleService.delete(id);
        return "redirect:/dashboard";
    }

}
