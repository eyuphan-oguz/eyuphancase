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

import com.eyuphancase.eyuphancase.model.vm.Company.AddCompanyVm;
import com.eyuphancase.eyuphancase.model.vm.Company.DeleteCompanyVm;
import com.eyuphancase.eyuphancase.model.vm.Company.GetAllCompanyVm;
import com.eyuphancase.eyuphancase.model.vm.Company.GetCompanyVm;
import com.eyuphancase.eyuphancase.model.vm.Company.UpdateCompanyVm;
import com.eyuphancase.eyuphancase.service.CompanyService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping()
    public ResponseEntity<List<GetAllCompanyVm>> getAllCompanyVm(){
        List<GetAllCompanyVm> getAllCompanyVm = companyService.getAllCompanyVm();
        return ResponseEntity.ok(getAllCompanyVm);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetCompanyVm> getCompanyVm(@PathVariable  Long id){
        GetCompanyVm getCompanyVm = companyService.getCompanyVm(id);
        return ResponseEntity.ok(getCompanyVm);
    }

    @PostMapping
    public ResponseEntity<AddCompanyVm> addCompanyVm(@RequestBody @Valid AddCompanyVm addCompanyVm){
        AddCompanyVm addCompanyVm2 = companyService.addCompanyVm(addCompanyVm);
        return ResponseEntity.status(HttpStatus.CREATED).body(addCompanyVm2);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteCompanyVm> deleteCompanyVm(@PathVariable Long id){
        DeleteCompanyVm deleteCompanyVm = companyService.deleteCompanyVm(id);
        return ResponseEntity.ok(deleteCompanyVm);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateCompanyVm> updateCompanyVm(@PathVariable Long id,@RequestBody @Valid UpdateCompanyVm updateCompanyVm){
        UpdateCompanyVm updateCompanyVm2 = companyService.updateCompanyVm(id,updateCompanyVm);
        return ResponseEntity.ok(updateCompanyVm2);
    }
    
}
