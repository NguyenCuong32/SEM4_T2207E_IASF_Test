package com.example.rematch.controller;

import com.example.rematch.entity.Employee;
import com.example.rematch.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {

        this.employeeService = employeeService;
    }
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }
    @GetMapping("/list")
    public String GetStudents(Model model) {
        List<Employee> employees = employeeService.getAllEmployee();
        model.addAttribute("employees", employees);
        return "employee/index";
    }

    @GetMapping("/formAdd")
    public String ShowFormAdd(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employee/addNew";
    }

    @PostMapping("/save")
    public String SaveStudent(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "employee/addNew";
        } else {
            employeeService.addNewEmployee(employee);
            return "redirect:/employee/list";
        }
    }

    @GetMapping("formUpdate")
    public String ShowFormUpdate(@RequestParam("employeeId") String employeeId, Model model) {
        Optional<Employee> employee = employeeService.getEmployeeById(employeeId);
        model.addAttribute("employee", employee);
        return "employee/addNew";
    }
    @GetMapping("delete")
    public String DeleteStudent(@RequestParam("employeeId") String employeeId, Model model){
        employeeService.deleteEmployee(employeeId);
        return "redirect:/employee/list";
    }
}