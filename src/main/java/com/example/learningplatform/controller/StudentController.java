package com.example.learningplatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/register")
    public ResponseEntity<Student> register(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.registerStudent(student.getUsername(), student.getPassword(), student.getEmail()));
    }

    @PostMapping("/login")
    public ResponseEntity<Student> login(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.loginStudent(student.getUsername(), student.getPassword()));
    }
}
