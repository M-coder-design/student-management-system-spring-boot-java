package com.example.studentmanagementsystem.service.impl;

import com.example.studentmanagementsystem.dto.StudentDTO;
import com.example.studentmanagementsystem.entity.Student;
import com.example.studentmanagementsystem.mapper.StudentMapper;
import com.example.studentmanagementsystem.repository.StudentRepository;
import com.example.studentmanagementsystem.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository)
    {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDTO> getAllStudents()
    {
        List<Student> students = studentRepository.findAll();
        List<StudentDTO> studentDTOS = students.stream().map((student)-> StudentMapper.mapToStudentDTO(student)).collect(Collectors.toList());

        return studentDTOS;
    }

    @Override
    public void createStudent(StudentDTO student)
    {
        Student newStudent = StudentMapper.mapToStudent(student);
        studentRepository.save(newStudent);
    }

    @Override
    public StudentDTO getStudentById(Long studentId) {
        Student student = studentRepository.findById(studentId).get();
        StudentDTO studentDTO = StudentMapper.mapToStudentDTO(student);
        return studentDTO;
    }

    @Override
    public void updateStudent(StudentDTO studentDTO) {
        studentRepository.save(StudentMapper.mapToStudent(studentDTO));
    }

    @Override
    public void deleteStudentById(Long studentId) {
        System.out.println("kkkkkkk");
        studentRepository.deleteById(studentId);
    }
}
