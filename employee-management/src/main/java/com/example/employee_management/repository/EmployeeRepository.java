package com.example.employee_management.repository;

import com.example.employee_management.model.Employee;  // Import the Employee entity
import org.springframework.data.jpa.repository.JpaRepository;  // Import JpaRepository from Spring Data JPA

/**
 * The EmployeeRepository interface is responsible for performing CRUD operations on the Employee entity.
 * By extending JpaRepository, we gain access to various methods for interacting with the database.
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
