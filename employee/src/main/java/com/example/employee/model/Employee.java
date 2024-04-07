package com.example.employee.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @PositiveOrZero(message = "Salary must be non-negative")
    private double salary;

    // Constructors, getters, setters, etc.

    public Employee() {
        // Default constructor for JPA
    }
    public Employee(@NotEmpty(message = "Name cannot be empty") String name,
            @PositiveOrZero(message = "Salary must be non-negative") double salary) {
       this.name = name;
       this.salary = salary;
}
    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(@PositiveOrZero(message = "Salary must be non-negative") double salary) {
        this.salary = salary;
    }
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}


    // toString, hashCode, equals, etc. (if needed)
}
