package org.example.baithith.admin.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class DashboardController {
    @GetMapping("/dashboard")
    public String getAdmin() {
        return "admin/dashboard";
    }
}
