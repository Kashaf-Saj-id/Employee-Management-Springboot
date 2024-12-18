package com.example.employee_management.controller;

import com.example.employee_management.model.Employee;
import com.example.employee_management.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class); // Create logger instance

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // POST endpoint to create an employee
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        logger.info("Received request to create employee: {}", employee.getName());  // Log request to create employee
        return employeeService.saveEmployee(employee);
    }

    // GET endpoint to fetch all employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        logger.info("Received request to fetch all employees."); // Log request to fetch all employees
        return employeeService.getAllEmployees();
    }

    // GET endpoint to fetch an employee by ID
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        logger.info("Received request to fetch employee with ID: {}", id);  // Log request to fetch employee by ID
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        if (employee.isPresent()) {
            return employee.get();
        } else {
            logger.error("Employee with ID: {} not found.", id);  // Log error if employee not found
            throw new RuntimeException("Employee not found with ID " + id);
        }
    }

    // PUT endpoint to update an employee completely
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        logger.info("Received request to update employee with ID: {}", id);  // Log request to update employee
        return employeeService.updateEmployee(id, employeeDetails);
    }

    // PATCH endpoint to update partial employee details
    @PatchMapping("/{id}")
    public Employee partiallyUpdateEmployee(@PathVariable Long id, @RequestBody Employee partialEmployee) {
        logger.info("Received request to partially update employee with ID: {}", id);  // Log partial update request
        return employeeService.partiallyUpdateEmployee(id, partialEmployee);
    }

    // DELETE endpoint to delete an employee
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        logger.info("Received request to delete employee with ID: {}", id);  // Log request to delete employee
        employeeService.deleteEmployeeById(id);
        return "Employee with ID " + id + " has been deleted successfully.";
    }
}
