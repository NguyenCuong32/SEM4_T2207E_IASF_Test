package com.example.prac.controller;

import com.example.prac.entities.Ventity;
import com.example.prac.service.IService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class Vcontroller {
    private final IService iService;

    public Vcontroller(IService iService) {
        this.iService = iService;
    }
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    @GetMapping("/list")
    public String GetStudents(Model model) {
        List<Ventity> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "student/index";
    }

    @GetMapping("/formAdd")
    public String ShowFormAdd(Model model) {
        Ventity ventity = new Ventity();
        model.addAttribute("student", ventity);
        return "student/addNew";
    }

    @PostMapping("/save")
    public String SaveStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "student/addNew";
        } else {
            studentService.addNewStudent(student);
            return "redirect:/student/list";
        }
    }

    @GetMapping("formUpdate")
    public String ShowFormUpdate(@RequestParam("studentId") Integer id, Model model) {
        Optional<Student> student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "student/addNew";
    }

    @GetMapping("delete")
    public String DeleteStudent(@RequestParam("studentId") Integer id, Model model) {
        studentService.deleteStudent(id);
        return "redirect:/student/list";
    }
}
