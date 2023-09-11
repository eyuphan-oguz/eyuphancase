package com.eyuphancase.eyuphancase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eyuphancase.eyuphancase.model.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{

    
    
}
