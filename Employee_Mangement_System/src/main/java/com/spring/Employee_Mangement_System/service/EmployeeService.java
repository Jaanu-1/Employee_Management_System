package com.spring.Employee_Mangement_System.service;

import com.spring.Employee_Mangement_System.exception.EmployeeNotFoundException;
import com.spring.Employee_Mangement_System.model.Employee;
import com.spring.Employee_Mangement_System.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    /**
     *
     * @return List of all the employees
     */
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    /**
     *
     * @param id of the employee to be fetched
     * @return the employee information of given id. If no employee found with given id exception is thrown
     */
    public Employee findEmployeeById(Integer id) {
        return getEmployeeById(id);
    }

    /**
     *
     * @param employee data to be created
     * @return data of employee created
     */
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    /**
     *
     * @param id of the employee to be deleted
     * @return success msg if employee present with given id. If no employee found with given id exception is thrown
     */
    public String deleteEmployeeById(Integer id) {
        Employee employee = getEmployeeById(id);
        employeeRepository.delete(employee);
        return "Employee with id: "+ id + " is deleted";
    }

    /**
     * Updates the employee data of given id. If no employee found with given id exception is thrown
     * @param id of the employee to be deleted
     * @param emp employee data to be modified/updated
     * @return updated data of employee
     */
    public Employee updateEmployee(Integer id, Employee emp) {
        Employee employee = getEmployeeById(id);
        employee.setName(emp.getName());
        employee.setGmail(emp.getGmail());
        employee.setSalary(emp.getSalary());
        return employeeRepository.save(employee);
    }

    /**
     *
     * @param id of the employee to be found
     * @return employee with given id. If no employee found with given id exception is thrown
     */
    private Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee with id " + id + " is not present"));
    }
}
