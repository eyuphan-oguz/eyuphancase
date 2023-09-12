package com.eyuphancase.eyuphancase.exception.company;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyErrorResponse {
    private int status;
    private String message;
    private Long timeStamp;
}
