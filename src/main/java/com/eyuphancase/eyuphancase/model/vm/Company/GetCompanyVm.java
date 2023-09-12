package com.eyuphancase.eyuphancase.model.vm.Company;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCompanyVm {
    @NotBlank 
    private String name;
}

