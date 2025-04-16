package com.example.learningplatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CourseRepository courseRepository;

    public Order createOrder(Long studentId, Long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        Order order = new Order(studentId, courseId, "Pending");
        return orderRepository.save(order);
    }
}
