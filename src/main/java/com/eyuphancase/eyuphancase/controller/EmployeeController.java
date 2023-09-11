package com.eyuphancase.eyuphancase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eyuphancase.eyuphancase.model.vm.Employee.AddEmployeeVm;
import com.eyuphancase.eyuphancase.model.vm.Employee.GetAllEmployeeVm;
import com.eyuphancase.eyuphancase.model.vm.Employee.GetEmployeeVm;
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

    @GetMapping()
    public ResponseEntity<List<GetAllEmployeeVm>> getAllEmployeeVm(){
        List<GetAllEmployeeVm> getAllCategoryVm = employeeService.getAllEmployeeVm();
        return ResponseEntity.ok(getAllCategoryVm);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetEmployeeVm> getEmployeeVm(@PathVariable  Long id){
        GetEmployeeVm getEmployeeVm = employeeService.getEmployeeVm(id);
        return ResponseEntity.ok(getEmployeeVm);
    }


     @PostMapping
    public ResponseEntity<AddEmployeeVm> addCategoryVm(@RequestBody @Valid AddEmployeeVm addEmployeeVm){
        AddEmployeeVm addEmployeeVm2 = employeeService.addEmployeeVm(addEmployeeVm);
        return ResponseEntity.status(HttpStatus.CREATED).body(addEmployeeVm2);
    }
    
}