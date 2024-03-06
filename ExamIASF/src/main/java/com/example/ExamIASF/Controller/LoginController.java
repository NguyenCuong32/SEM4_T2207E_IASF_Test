package com.example.ExamIASF.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/loginlogout")
    public String Login(){
        return "login";
    }
}
