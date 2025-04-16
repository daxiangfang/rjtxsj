package com.example.learningplatform.model;

import javax.persistence.*;

@Entity
@Table(name = "orders") // order是关键字，建议表名改为orders或其他名称
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentId;
    private Long courseId;
    private String status; // Pending, Paid, Canceled, Refunded

    public Order() {
    }

    public Order(Long studentId, Long courseId, String status) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.status = status;
    }

    // Getter and Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
