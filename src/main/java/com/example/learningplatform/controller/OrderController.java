package com.example.learningplatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<Order> createOrder(@RequestParam Long studentId, @RequestParam Long courseId) {
        return ResponseEntity.ok(orderService.createOrder(studentId, courseId));
    }
}
