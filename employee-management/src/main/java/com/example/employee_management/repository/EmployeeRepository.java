package com.example.employee_management.repository;

import com.example.employee_management.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    // Basic CRUD operations are available from CrudRepository.
    // Additional custom queries can be added if needed, such as:
    // @Query("SELECT e FROM Employee e WHERE e.salary > ?1")
    // List<Employee> findBySalaryGreaterThan(Double salary);
}
