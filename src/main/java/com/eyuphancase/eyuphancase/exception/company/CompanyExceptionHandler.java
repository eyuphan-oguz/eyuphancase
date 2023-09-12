package com.eyuphancase.eyuphancase.exception.company;
import java.lang.System;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class CompanyExceptionHandler {

    
     @ExceptionHandler(CompanyAlreadyExistsException.class)
    public ResponseEntity<CompanyErrorResponse>handleAlreadyExistException(CompanyAlreadyExistsException companyAlreadyExistsException){

        CompanyErrorResponse companyErrorResponse = new CompanyErrorResponse();

        companyErrorResponse.setStatus(HttpStatus.CONFLICT.value());
        companyErrorResponse.setMessage(companyAlreadyExistsException.getMessage());
        companyErrorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<CompanyErrorResponse>(companyErrorResponse, HttpStatus.CONFLICT);
    }


    @ExceptionHandler(CompanyNotFoundException.class)
    public ResponseEntity<CompanyErrorResponse>handleNotFoundException(CompanyNotFoundException companyNotFoundException){

        CompanyErrorResponse companyErrorResponse = new CompanyErrorResponse();

        companyErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        companyErrorResponse.setMessage(companyNotFoundException.getMessage());
        companyErrorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<CompanyErrorResponse>(companyErrorResponse, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(CompanyMethodArgumentNotValidException.class)
    public ResponseEntity<CompanyErrorResponse>handleMethodArgumentNotValidException(CompanyMethodArgumentNotValidException companyMethodArgumentNotValidException){

        CompanyErrorResponse companyErrorResponse = new CompanyErrorResponse();

        companyErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        companyErrorResponse.setMessage(companyMethodArgumentNotValidException.getMessage());
        companyErrorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<CompanyErrorResponse>(companyErrorResponse, HttpStatus.BAD_REQUEST);
    }


}
