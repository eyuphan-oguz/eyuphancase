package com.eyuphancase.eyuphancase.model.vm.Employee;

import com.eyuphancase.eyuphancase.model.vm.Company.GetCompanyVm;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetEmployeeVm {
    
    @NotBlank 
    private String name;

    @NotBlank 
    private String surname;

    @NotBlank 
    private String mail;

    @NotNull
    private Long companyId;

    @NotBlank 
    private GetCompanyVm company;
}
