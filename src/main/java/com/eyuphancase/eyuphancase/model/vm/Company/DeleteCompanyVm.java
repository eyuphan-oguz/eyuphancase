package com.eyuphancase.eyuphancase.model.vm.Company;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteCompanyVm {
    @NotNull
    private Long id;
}
