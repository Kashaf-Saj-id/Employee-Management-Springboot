package com.example.employee_management.controller;

import com.example.employee_management.model.Employee;  // Import the Employee model
import com.example.employee_management.service.EmployeeService;  // Import the EmployeeService
import org.springframework.beans.factory.annotation.Autowired;  // Import Autowired for dependency injection
import org.springframework.web.bind.annotation.*;  // Import the required Spring Web annotations

import java.util.List;

/**
 * The EmployeeController class defines the REST API endpoints for managing employees.
 * It acts as a controller for handling HTTP requests and delegating the business logic
 * to the EmployeeService class.
 */

@RestController  // Marks this class as a REST controller
@RequestMapping("/employees")  // Defines the base URL for all endpoints in this controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;  // Inject the EmployeeService to handle business logic

    /**
     * Endpoint to create a new employee with their addresses and departments.
     * This is a POST request where the employee data is sent in the request body.
     */
    @PostMapping
    public Employee createEmployeeWithAddressesAndDepartments(@RequestBody Employee employee)//This annotation tells Spring to automatically convert the incoming JSON or XML payload into an Employee object.
     {
        return employeeService.saveEmployeeWithAddressesAndDepartments(employee);
    }

    /**
     * Endpoint to get all employees.
     * This is a GET request that retrieves the list of all employees from the service.
     */
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    /**
     * Endpoint to get a specific employee by their ID.
     * This is a GET request where the employee ID is passed as a path variable.
     */
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) { //This annotation binds the {id} from the URL path
        return employeeService.getEmployeeById(id);
    }

    /**
     * Endpoint to update an existing employee.
     * This is a PUT request where the employee ID is passed in the URL and the updated employee data is sent in the request body.
     */
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
        return employeeService.updateEmployee(id, updatedEmployee);
    }

    /**
     * Endpoint to delete an employee by their ID.
     * This is a DELETE request where the employee ID is passed as a path variable.
     */
    @DeleteMapping("/{id}")
    public String deleteEmployeeById(@PathVariable Long id) {
        employeeService.deleteEmployeeById(id);
        return "Employee with ID " + id + " has been deleted.";  // Return a confirmation message
    }
}
