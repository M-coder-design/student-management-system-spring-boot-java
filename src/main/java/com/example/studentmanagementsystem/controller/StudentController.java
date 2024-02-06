package com.example.studentmanagementsystem.controller;

import com.example.studentmanagementsystem.dto.StudentDTO;
import com.example.studentmanagementsystem.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {

    private StudentService studentService;
    public StudentController(StudentService studentService)
    {
        this.studentService = studentService;
    }

    @GetMapping("students")
    public String getAllStudents(Model model){
        List<StudentDTO> students = studentService.getAllStudents();
        model.addAttribute("students",students);
        return "students";
    }

    @GetMapping("students/new")
    public String newStudent(Model model)
    {
        StudentDTO studentDTO = new StudentDTO();
        model.addAttribute("students",studentDTO);
        return "create_student";
    }

    @PostMapping("students")
    public String createStudent(@Valid @ModelAttribute("students") StudentDTO studentdto,
                                BindingResult result,
                                Model model)
    {
        if(result.hasErrors())
        {
            model.addAttribute("students",studentdto);
            return "create_student";
        }
        studentService.createStudent(studentdto);
        return "redirect:/students";
    }

    @GetMapping("students/{studentId}/edit")
    public String editStudent(@PathVariable("studentId") Long studentId,
                              Model model)
    {
        StudentDTO studentDTO = studentService.getStudentById(studentId);
        model.addAttribute("student",studentDTO);
        return "edit_student";
    }

    @PostMapping("student/{studentId}")
    public String updateStudent(@PathVariable("studentId") Long studentId,
                                @Valid @ModelAttribute("student") StudentDTO studentDTO,
                                BindingResult bindingResult, Model model)
    {
        if(bindingResult.hasErrors())
        {
            model.addAttribute("student",studentDTO);
            return "edit_student";
        }
        studentDTO.setId(studentId);
        studentService.updateStudent(studentDTO);
        return "redirect:/students";
    }

    @GetMapping("students/{studentId}/delete")
    public String deleteStudent(@PathVariable("studentId") Long studentId)
    {
        studentService.deleteStudentById(studentId);
        return "redirect:/students";
    }

    @GetMapping("students/{studentId}/view")
    public String viewStudent(@PathVariable("studentId") Long studentId,Model model)
    {
        StudentDTO studentDTO = studentService.getStudentById(studentId);
        model.addAttribute("student",studentDTO);
        return "view_student";
    }
}
