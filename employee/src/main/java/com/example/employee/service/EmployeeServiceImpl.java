package com.example.employee.service;

import com.example.employee.controller.EmployeeController;
import com.example.employee.exception.EmployeeNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Override
    public List<Employee> getAllEmployees() {
    	logger.info("Fetching all employees");
        List<Employee> employees = employeeRepository.findAll();
        logger.info("Fetched {} employees", employees.size());
        return employees;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        return optionalEmployee.orElseThrow(() -> new EmployeeNotFoundException("Employee not found with ID: " + id));
    }
    @Transactional
    @Override
    public Employee createEmployee(Employee employee) {
        // Additional validation logic can be added if needed
    	System.out.println("Received Employee: " + employee);
        return employeeRepository.save(employee);
    }
    @Transactional
    @Override
    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee existingEmployee = optionalEmployee.get();
            existingEmployee.setName(updatedEmployee.getName());
            existingEmployee.setSalary(updatedEmployee.getSalary());
            return employeeRepository.save(existingEmployee);
        } else {
            throw new EmployeeNotFoundException("Employee not found with ID: " + id);
        }
    }
    @Transactional
    @Override
    public void deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        } else {
            throw new EmployeeNotFoundException("Employee not found with ID: " + id);
        }
    }
}

