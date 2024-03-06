package com.uni.finaltest.controllers;

import com.uni.finaltest.entity.Vehicle;
import com.uni.finaltest.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.logout.DelegatingServerLogoutHandler;
import org.springframework.security.web.server.authentication.logout.SecurityContextServerLogoutHandler;
import org.springframework.security.web.server.authentication.logout.WebSessionServerLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class MonitorController {
    private final VehicleService vehicleService;
    @Autowired
    public MonitorController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/list")
    public String Catalogue(Model model){
        var vehicles = vehicleService.getEveryVehicles();
        model.addAttribute("vehicles", vehicles);
        return "monitor";
    }
    @PostMapping("/save")
    public String Save (@ModelAttribute("vehicle") Vehicle vehicle){
        vehicleService.save(vehicle);
        return "redirect:/list";
    }
    @GetMapping("formUpdate")
    public String ShowFormUpdate(@RequestParam("vehicleId") Integer id, Model model) {
        Optional<Vehicle> student = vehicleService.getVehicleById(id);
        model.addAttribute("vehicle", vehicle);
        return "addNew";
    }
    @GetMapping("delete")
    public String DeleteVehicle(@RequestParam("vehicleId") Integer id, Model model) {
        vehicleService.deleteVehicle(id);
        return "redirect:/list";
    }
    public SecurityWebFilterChain http(ServerHttpSecurity http) throws Exception {
        DelegatingServerLogoutHandler logoutHandler = new DelegatingServerLogoutHandler(
                new WebSessionServerLogoutHandler(), new SecurityContextServerLogoutHandler()
        );
        http
                .authorizeExchange((exchange)-> exchange.anyExchange().authenticated())
                .logout((logout)->logout.logoutHandler(logoutHandler));
        return http.build();
    }
}
