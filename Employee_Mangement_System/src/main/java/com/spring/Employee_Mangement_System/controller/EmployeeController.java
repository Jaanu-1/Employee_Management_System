package com.spring.Employee_Mangement_System.controller;

import com.spring.Employee_Mangement_System.model.Employee;
import com.spring.Employee_Mangement_System.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/find/{id}")
    public Employee findEmployeeById(@PathVariable Integer id) {
        return employeeService.findEmployeeById(id);
    }

    @PostMapping("/create")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployeeById(@PathVariable Integer id) {
        return employeeService.deleteEmployeeById(id);
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }
}
