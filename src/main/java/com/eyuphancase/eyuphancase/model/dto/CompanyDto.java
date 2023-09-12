package com.eyuphancase.eyuphancase.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CompanyDto {
    @NotNull
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private Long companyId;
}
