package com.hdquoc.exam_2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {
    @GetMapping("/login_page")
    public String formLogin(){
        return "login";
    }
}
