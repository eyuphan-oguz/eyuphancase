package com.eyuphancase.eyuphancase.service.impl;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eyuphancase.eyuphancase.exception.employee.EmployeeAlreadyExistsException;
import com.eyuphancase.eyuphancase.exception.employee.EmployeeMethodArgumentNotValidException;
import com.eyuphancase.eyuphancase.model.dto.EmployeeDto;
import com.eyuphancase.eyuphancase.model.entity.Employee;
import com.eyuphancase.eyuphancase.model.vm.Employee.AddEmployeeVm;
import com.eyuphancase.eyuphancase.repository.EmployeeRepository;
import com.eyuphancase.eyuphancase.service.EmployeeService;
import com.eyuphancase.eyuphancase.util.mapper.ModelMapperManager;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    
    private ModelMapperManager modelMapperManager;
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(ModelMapperManager modelMapperManager, EmployeeRepository employeeRepository) {
        this.modelMapperManager = modelMapperManager;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public AddEmployeeVm addEmployeeVm(AddEmployeeVm addEmployeeVm) {
       List<Employee> employeeList = employeeRepository.findByMailIgnoreCase(addEmployeeVm.getMail());

       if (!employeeList.isEmpty()) {
        for (Employee employee : employeeList) {
            if (!employee.isActive()) {
                employee.setActive(true);
                employeeRepository.save(employee);
            } else {
                throw new EmployeeAlreadyExistsException("Bu çalışan sisteme zaten kayıtlı!!!");
            }
        }
    }

    else if (addEmployeeVm.getName().length() <= 3 || addEmployeeVm.getName().length() >= 100) {
        throw new EmployeeMethodArgumentNotValidException("Çalışanın adı minimum 3 maksimum 100 karakter olmalıdır.");
    }

    else{
        EmployeeDto employeeDto = modelMapperManager.forRequest().map(addEmployeeVm,EmployeeDto.class);
        Employee employee = modelMapperManager.forRequest().map(employeeDto, Employee.class);
        employeeRepository.save(employee);
        }

        return addEmployeeVm;
    }

    

}
