package com.example.learningplatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found"));
    }

    public Course addCourse(String title, String description, Double price) {
        Course course = new Course(title, description, price);
        return courseRepository.save(course);
    }
}
