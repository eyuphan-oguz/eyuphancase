package com.eyuphancase.eyuphancase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eyuphancase.eyuphancase.model.vm.Employee.AddEmployeeVm;
import com.eyuphancase.eyuphancase.model.vm.Employee.DeleteEmployeeVm;
import com.eyuphancase.eyuphancase.model.vm.Employee.GetAllEmployeeVm;
import com.eyuphancase.eyuphancase.model.vm.Employee.GetEmployeeVm;
import com.eyuphancase.eyuphancase.model.vm.Employee.UpdateEmployeeVm;
import com.eyuphancase.eyuphancase.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employees")
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
        GetEmployeeVm getEmployeeVm2 = employeeService.getEmployeeVm(id);
        return ResponseEntity.ok(getEmployeeVm2);
    }


    @PostMapping
    public ResponseEntity<AddEmployeeVm> addEmployeeVm(@RequestBody @Valid AddEmployeeVm addEmployeeVm){
        AddEmployeeVm addEmployeeVm2 = employeeService.addEmployeeVm(addEmployeeVm);
        return ResponseEntity.status(HttpStatus.CREATED).body(addEmployeeVm2);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteEmployeeVm> deleteEmployeeVm(@PathVariable Long id){
        DeleteEmployeeVm deleteCategoryVm2 = employeeService.deleteEmployeeVm(id);
        return ResponseEntity.ok(deleteCategoryVm2);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateEmployeeVm> updateCategoryVm(@PathVariable Long id,@RequestBody @Valid UpdateEmployeeVm updateEmployeeVm){
        UpdateEmployeeVm updateEmployeeVm2 = employeeService.updateEmployeeVm(id,updateEmployeeVm);
        return ResponseEntity.ok(updateEmployeeVm2);
    }
    
}
