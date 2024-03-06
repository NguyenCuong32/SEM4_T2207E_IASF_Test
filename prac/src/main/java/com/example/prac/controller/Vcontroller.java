package com.example.prac.controller;

import com.example.prac.service.IService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class Vcontroller {
    private final IService iService;

    public Vcontroller(IService iService) {
        this.iService = iService;
    }
}
