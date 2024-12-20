package com.example.employee_management.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The Employee class represents an employee in the system.
 * It contains information such as the employee's name, salary, date of birth, and associated addresses and departments.
 * The class uses JPA for database interaction.
 */
@Entity  // Marks this class as a JPA entity (this will be mapped to a table in the database)
public class Employee {

    @Id  // Marks this field as the primary key for the employee
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double salary;
    private String dob;

    // One-to-Many relationship with the Address entity. An employee can have multiple addresses.
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "employee_id")  // Specifies the foreign key column name in the Address table
    private List<Address> addresses;  // A list of addresses associated with the employee

    // Many-to-Many relationship with the Department entity. An employee can belong to multiple departments.
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "employee_department",  // Specifies the name of the join table
            joinColumns = @JoinColumn(name = "employee_id"),  // Foreign key column in the join table for employee_id
            inverseJoinColumns = @JoinColumn(name = "department_id")  // Foreign key column in the join table for department_id
    )
    private List<Department> departments = new ArrayList<>();  // A list of departments the employee belongs to


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


    public String getDob() {
        return dob;
    }


    public void setDob(String dob) {
        this.dob = dob;
    }


    public List<Address> getAddresses() {
        return addresses;
    }


    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }


    public List<Department> getDepartments() {
        return departments;
    }


    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}
