package org.example.exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {
    @GetMapping("/login")
    public String login(){
        return "/loginForm";
    }

    @GetMapping("/access-denied")
    public String accessDenied(){
        return "/access-denied";
    }
}