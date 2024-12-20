package com.example.employee_management.service;

import com.example.employee_management.model.Employee;  // Import Employee model
import com.example.employee_management.repository.DepartmentRepository;  // Import Department repository
import com.example.employee_management.repository.EmployeeRepository;  // Import Employee repository
import org.springframework.beans.factory.annotation.Autowired;  // Import Autowired for dependency injection
import org.springframework.stereotype.Service;  // Import Service annotation

import java.util.List;

/**
 * The EmployeeService class provides methods for managing employees,
 * including saving, updating, deleting, and retrieving employee data.
 */

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;  // Inject the EmployeeRepository to interact with the employee data

    @Autowired
    private DepartmentRepository departmentRepository;  // Inject the DepartmentRepository to handle department-related data

    /**
     * Save a new employee along with their associated addresses and departments.
     * If the department does not already exist, it will be saved to the database.
     *
     */
    public Employee saveEmployeeWithAddressesAndDepartments(Employee employee) {
        // Loop through all the departments assigned to this employee
        employee.getDepartments().forEach(department -> {
            // If a department doesn't have an ID, it means it is new, so save it
            if (department.getId() == null) {
                departmentRepository.save(department);  // Save the new department
            }
        });

        // Now save the employee (along with the addresses and updated departments)
        return employeeRepository.save(employee);
    }


    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();  // Return all employees using the repository's findAll method
    }


    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee with ID " + id + " not found."));  // Throw an exception if not found
    }


    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        // Fetch the existing employee from the database
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee with ID " + id + " not found."));  // Throw an exception if the employee is not found

        // Update the basic fields of the employee (name, salary, date of birth)
        existingEmployee.setName(updatedEmployee.getName());
        existingEmployee.setSalary(updatedEmployee.getSalary());
        existingEmployee.setDob(updatedEmployee.getDob());

        // Handle addresses (clear existing ones and add new ones)
        existingEmployee.getAddresses().clear();  // Clear the current list of addresses
        existingEmployee.getAddresses().addAll(updatedEmployee.getAddresses());  // Add all new addresses

        // Handle departments (save new departments and update the list)
        updatedEmployee.getDepartments().forEach(department -> {
            // If the department doesn't already have an ID, it's new, so we need to save it
            if (department.getId() == null) {
                departmentRepository.save(department);  // Save the new department
            }
        });
        // Update the existing employee with the new list of departments
        existingEmployee.setDepartments(updatedEmployee.getDepartments());

        // Save the updated employee and return the result
        return employeeRepository.save(existingEmployee);
    }


    public void deleteEmployeeById(Long id) {
        // Check if the employee exists before attempting to delete
        if (!employeeRepository.existsById(id)) {
            throw new RuntimeException("Employee with ID " + id + " not found.");  // Throw an exception if not found
        }
        // Delete the employee by their ID
        employeeRepository.deleteById(id);
    }
}
