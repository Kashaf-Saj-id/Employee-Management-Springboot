package com.example.employee_management.repository;

import com.example.employee_management.model.Department;  // Import the Department entity
import org.springframework.data.jpa.repository.JpaRepository;  // Import JpaRepository from Spring Data JPA

/**
 * The DepartmentRepository interface is responsible for performing CRUD operations on the Department entity.
 * By extending JpaRepository, we gain access to various methods for interacting with the database.
 */
public interface DepartmentRepository extends JpaRepository<Department, Long> { //is a generic interface that comes from Spring Data JPA.
    // We can write custom queries here, JpaRepository provides all basic CRUD methods
}
