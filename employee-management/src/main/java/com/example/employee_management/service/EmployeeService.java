package com.example.employee_management.service;

import com.example.employee_management.model.Employee;
import com.example.employee_management.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class); // Create logger instance

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Method to save an employee to the database
    public Employee saveEmployee(Employee employee) {
        logger.info("Saving employee with name: {}", employee.getName());  // Log when employee is being saved
        return employeeRepository.save(employee);
    }

    // Method to fetch all employees from the database
    public List<Employee> getAllEmployees() {
        logger.info("Fetching all employees."); // Log when fetching all employees
        return (List<Employee>) employeeRepository.findAll();
    }

    // Method to fetch an employee by ID
    public Optional<Employee> getEmployeeById(Long id) {
        logger.info("Fetching employee with ID: {}", id);  // Log when fetching employee by ID
        return employeeRepository.findById(id);
    }

    // Method to update employee (PUT)
    public Employee updateEmployee(Long id, Employee updatedDetails) {
        logger.info("Updating employee with ID: {}", id);  // Log when employee is being updated
        return employeeRepository.findById(id).map(employee -> {
            employee.setName(updatedDetails.getName());
            employee.setSalary(updatedDetails.getSalary());
            employee.setDob(updatedDetails.getDob());
            return employeeRepository.save(employee);
        }).orElseThrow(() -> new RuntimeException("Employee not found with ID " + id));
    }

    // Method to partially update employee (PATCH)
    public Employee partiallyUpdateEmployee(Long id, Employee partialDetails) {
        logger.info("Partially updating employee with ID: {}", id);  // Log when partially updating employee
        return employeeRepository.findById(id).map(employee -> {
            if (partialDetails.getName() != null) {
                employee.setName(partialDetails.getName());
            }
            if (partialDetails.getSalary() != null) {
                employee.setSalary(partialDetails.getSalary());
            }
            if (partialDetails.getDob() != null) {
                employee.setDob(partialDetails.getDob());
            }
            return employeeRepository.save(employee);
        }).orElseThrow(() -> new RuntimeException("Employee not found with ID " + id));
    }

    // Method to delete an employee by ID
    public void deleteEmployeeById(Long id) {
        logger.info("Deleting employee with ID: {}", id);  // Log when employee is being deleted
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        } else {
            throw new RuntimeException("Employee not found with ID " + id);
        }
    }
}
