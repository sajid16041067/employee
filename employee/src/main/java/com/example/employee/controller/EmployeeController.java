package com.example.employee.controller;

import com.example.employee.dto.EmployeeDTO;
import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
    	logger.info("Fetching all employees");
        List<Employee> employees = employeeService.getAllEmployees();
        logger.info("Fetched {} employees", employees.size());
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @PostMapping
    public ResponseEntity<String> createEmployee(@Valid @RequestBody EmployeeDTO employeedto, BindingResult bindingResult) {
    	 if (bindingResult.hasErrors()) {
             // Handle validation errors, e.g., return a response with error details
             return ResponseEntity.badRequest().body("Validation error: " + bindingResult.getAllErrors());
         }
    	 logger.info("Creating employee: {}", employeedto);
    	 Employee employee=new Employee(employeedto.getName(),employeedto.getSalary());
        Employee createdEmployee = employeeService.createEmployee(employee);
        logger.info("Employee created successfully: {}", createdEmployee);
        return ResponseEntity.ok("SUccess");
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeDTO employeedto, BindingResult bindingResult) {
    	if (bindingResult.hasErrors()) {
            // Handle validation errors, e.g., return a response with error details
            return ResponseEntity.badRequest().body("Validation error: " + bindingResult.getAllErrors());
        }
    	logger.info("Updating employee: {}", employeedto);
    	Employee updatedEmployee=new Employee(employeedto.getName(),employeedto.getSalary());
        Employee employee = employeeService.updateEmployee(id, updatedEmployee);
        logger.info("Employee updated successfully: {}", updatedEmployee);
        return ResponseEntity.ok("updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("deleted ");
    }
}

