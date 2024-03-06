package com.example.rematch.controller;

import com.example.rematch.service.VehicleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    private final VehicleService studentService;

    public HomeController(VehicleService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String Index(Model model){
        return  "index";
    }
}
