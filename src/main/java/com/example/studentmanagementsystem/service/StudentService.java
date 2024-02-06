package com.example.studentmanagementsystem.service;

import com.example.studentmanagementsystem.dto.StudentDTO;
import com.example.studentmanagementsystem.entity.Student;

import java.util.List;

public interface StudentService {

    public List<StudentDTO> getAllStudents();

    public void createStudent(StudentDTO student);

    StudentDTO getStudentById(Long studentId);

    void updateStudent(StudentDTO studentDTO);

    void deleteStudentById(Long studentId);
}
