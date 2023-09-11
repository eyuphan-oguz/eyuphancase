package com.eyuphancase.eyuphancase.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eyuphancase.eyuphancase.repository.EmployeeRepository;
import com.eyuphancase.eyuphancase.util.mapper.ModelMapperManager;

@Service
public class EmployeeServiceImpl {
    
    private ModelMapperManager modelMapperManager;
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(ModelMapperManager modelMapperManager, EmployeeRepository employeeRepository) {
        this.modelMapperManager = modelMapperManager;
        this.employeeRepository = employeeRepository;
    }

    

}
