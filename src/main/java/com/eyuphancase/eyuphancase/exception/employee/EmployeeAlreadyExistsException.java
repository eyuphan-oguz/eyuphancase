package com.eyuphancase.eyuphancase.exception.employee;

public class EmployeeAlreadyExistsException extends RuntimeException{

    public EmployeeAlreadyExistsException(String message){
        super(message);
    }
    
}
