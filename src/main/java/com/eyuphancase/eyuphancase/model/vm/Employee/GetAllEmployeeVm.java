package com.eyuphancase.eyuphancase.model.vm.Employee;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllEmployeeVm {

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String name;


    @NotNull
    @NotBlank
    @Size(max = 100)
    private String surname;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String mail;

    @NotNull
    private Long companyId;
}
