package org.example.exam.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/default")
    public String successPage(HttpServletRequest request){
        if(request.isUserInRole("ADMIN")){
            return "redirect:/indexAdmin";
        }
        return "redirect:/indexUser";
    }

    @GetMapping("/indexAdmin")
    public String indexAdmin(){
        return "Vehicle/indexAdmin";
    }

    @GetMapping("/indexUser")
    public String indexUser(){
        return "Vehicle/indexUser";
    }

}
