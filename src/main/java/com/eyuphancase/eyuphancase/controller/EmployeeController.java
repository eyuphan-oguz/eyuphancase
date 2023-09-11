package com.eyuphancase.eyuphancase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eyuphancase.eyuphancase.model.vm.Employee.AddEmployeeVm;
import com.eyuphancase.eyuphancase.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


     @PostMapping
    public ResponseEntity<AddEmployeeVm> addCategoryVm(@RequestBody @Valid AddEmployeeVm addEmployeeVm){
        AddEmployeeVm addEmployeeVm2 = employeeService.addEmployeeVm(addEmployeeVm);
        return ResponseEntity.status(HttpStatus.CREATED).body(addEmployeeVm2);
    }
    
}
