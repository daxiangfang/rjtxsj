package com.example.learningplatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student registerStudent(String username, String password, String email) {
        Student student = new Student(username, password, email);
        return studentRepository.save(student);
    }

    public Student loginStudent(String username, String password) {
        return studentRepository.findByUsername(username)
                .filter(student -> student.getPassword().equals(password))
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
    }
}
