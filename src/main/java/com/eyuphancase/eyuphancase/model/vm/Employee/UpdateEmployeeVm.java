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
public class UpdateEmployeeVm {
    @NotNull
    @NotBlank
    @Size(max = 100,min = 3)
    private String mail;
}
