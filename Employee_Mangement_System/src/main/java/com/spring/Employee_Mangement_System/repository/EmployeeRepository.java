package com.spring.Employee_Mangement_System.repository;

import com.spring.Employee_Mangement_System.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
