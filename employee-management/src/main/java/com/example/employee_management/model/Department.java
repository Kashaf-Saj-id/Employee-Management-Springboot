package com.example.employee_management.model;

import com.fasterxml.jackson.annotation.JsonIgnore;  // You use it to stop infinite loops or to hide unnecessary details when converting an object to JSON.
import jakarta.persistence.*;  // JPA annotations for persistence (database interaction)
import java.util.List;  // Importing List to represent a collection of employees

/**
 * The Department class represents a department within an organization.
 * It contains information about the department's role, head, and associated employees.
 * This class uses JPA for database mapping and Jackson annotations to control JSON serialization.
 */

@Entity  // Marks this class as a JPA entity (this will be mapped to a table in the database)
public class Department {

    // Unique identifier for each department (Primary Key in the database)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Automatically generates a unique ID for each department
    private Long id;  // Primary key for the Department entity

    private String role;
    private String head;

    // Relationship with employees. A department can have multiple employees.
    @ManyToMany(mappedBy = "departments")
    @JsonIgnore  // Prevents the 'employees' field from being serialized into JSON (avoiding infinite recursion)
    private List<Employee> employees;

    //Getters and setters
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getRole() {
        return role;
    }


    public void setRole(String role) {
        this.role = role;
    }


    public String getHead() {
        return head;
    }


    public void setHead(String head) {
        this.head = head;
    }


    public List<Employee> getEmployees() {
        return employees;
    }


    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
