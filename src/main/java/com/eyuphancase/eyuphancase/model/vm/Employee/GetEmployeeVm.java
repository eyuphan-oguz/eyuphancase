package com.eyuphancase.eyuphancase.model.vm.Employee;

import jakarta.validation.constraints.NotBlank;
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
}
