package com.eyuphancase.eyuphancase.model.vm.Employee;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteEmployeeVm {
    @NotNull
    private Long id;
}
