package com.eyuphancase.eyuphancase.model.vm.Employee;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor


public class AddEmployeeVm {
    
    @NotNull
    @NotBlank
    @Size(max = 100,min = 3)
    private String name;


    @NotNull
    @NotBlank
    @Size(max = 100,min = 3)
    private String surname;

    @NotNull
    @NotBlank
    @Email
    @Size(max = 150,min = 3)
    private String mail;


}
