package com.eyuphancase.eyuphancase.exception.employee;
import java.lang.System;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeExceptionHandler {


    @ExceptionHandler(EmployeeAlreadyExistsException.class)
    public ResponseEntity<EmployeeErrorResponse>handleAlreadyExistException(EmployeeAlreadyExistsException employeeAlreadyExistsException){

        EmployeeErrorResponse employeeErrorResponse = new EmployeeErrorResponse();

        employeeErrorResponse.setStatus(HttpStatus.CONFLICT.value());
        employeeErrorResponse.setMessage(employeeAlreadyExistsException.getMessage());
        employeeErrorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<EmployeeErrorResponse>(employeeErrorResponse, HttpStatus.CONFLICT);
    }


    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<EmployeeErrorResponse>handleNotFoundException(EmployeeNotFoundException employeeNotFoundException){

        EmployeeErrorResponse employeeErrorResponse = new EmployeeErrorResponse();

        employeeErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        employeeErrorResponse.setMessage(employeeNotFoundException.getMessage());
        employeeErrorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<EmployeeErrorResponse>(employeeErrorResponse, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(EmployeeMethodArgumentNotValidException.class)
    public ResponseEntity<EmployeeErrorResponse>handleMethodArgumentNotValidException(EmployeeMethodArgumentNotValidException employeeMethodArgumentNotValidException){

        EmployeeErrorResponse employeeErrorResponse = new EmployeeErrorResponse();

        employeeErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        employeeErrorResponse.setMessage(employeeMethodArgumentNotValidException.getMessage());
        employeeErrorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<EmployeeErrorResponse>(employeeErrorResponse, HttpStatus.BAD_REQUEST);
    }

}
