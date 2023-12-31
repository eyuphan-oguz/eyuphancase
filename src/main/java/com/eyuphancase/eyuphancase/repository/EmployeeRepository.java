package com.eyuphancase.eyuphancase.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eyuphancase.eyuphancase.model.entity.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{

    List<Employee> findByMailIgnoreCase(String mail);

    List<Employee> findByActive(boolean active);

    Employee findByIdAndActiveTrue(Long id);

    boolean existsByIdAndActiveTrue(Long id);
    
}
