package com.example.employee.dto;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;

public class EmployeeDTO {

    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @PositiveOrZero(message = "Salary must be non-negative")
    private double salary;

    // Constructors, getters, setters, etc.

    public EmployeeDTO() {
        // Default constructor
    }

    public EmployeeDTO(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
