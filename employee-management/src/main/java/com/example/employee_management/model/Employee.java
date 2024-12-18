package com.example.employee_management.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;

public class Employee {
    @Id
    private Long id;         // Mark this field as the identifier (primary key) for the Employee

    private String name;     // Employee name
    private Double salary;   // Employee salary
    private LocalDate dob;   // Date of Birth of the employee

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}
