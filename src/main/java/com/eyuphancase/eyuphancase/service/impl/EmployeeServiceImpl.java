package com.eyuphancase.eyuphancase.service.impl;

import java.util.List;
import java.util.Locale.Category;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eyuphancase.eyuphancase.exception.employee.EmployeeAlreadyExistsException;
import com.eyuphancase.eyuphancase.exception.employee.EmployeeMethodArgumentNotValidException;
import com.eyuphancase.eyuphancase.exception.employee.EmployeeNotFoundException;
import com.eyuphancase.eyuphancase.model.dto.EmployeeDto;
import com.eyuphancase.eyuphancase.model.entity.Employee;
import com.eyuphancase.eyuphancase.model.vm.Employee.AddEmployeeVm;
import com.eyuphancase.eyuphancase.model.vm.Employee.DeleteEmployeeVm;
import com.eyuphancase.eyuphancase.model.vm.Employee.GetAllEmployeeVm;
import com.eyuphancase.eyuphancase.model.vm.Employee.GetEmployeeVm;
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

    
    @Override
    public List<GetAllEmployeeVm> getAllEmployeeVm() {
        List<EmployeeDto> employeeDtos = employeeRepository.findByActive(true).stream().map(employee ->modelMapperManager.forResponse().map(employee,EmployeeDto.class)).collect(Collectors.toList());
        List<GetAllEmployeeVm> getAllEmployeeVms = employeeDtos.stream().map(categoryDto -> modelMapperManager.forResponse().map(categoryDto, GetAllEmployeeVm.class)).collect(Collectors.toList());
        return getAllEmployeeVms;
    }

    @Override
    public GetEmployeeVm getEmployeeVm(Long id) {
        if(!existsById(id)){
            throw new EmployeeNotFoundException("Veritabanında böyle bir kayıt bulunamadı.");
        }
        Employee employee = employeeRepository.findByIdAndActiveTrue(id);
        EmployeeDto employeeDto = modelMapperManager.forResponse().map(employee,EmployeeDto.class);
        GetEmployeeVm getEmployeeVm = modelMapperManager.forResponse().map(employeeDto, GetEmployeeVm.class);

        return getEmployeeVm;
    }

    @Override
    public boolean existsById(Long id) {
        return employeeRepository.existsByIdAndActiveTrue(id) ? true : false;
    }

    @Override
    public DeleteEmployeeVm deleteEmployeeVm(Long id) {
        if(!existsById(id)){
            throw new EmployeeNotFoundException("Veritabanıda böyle bir kayıt bulunamadı.");
        }
        Employee employee = employeeRepository.findById(id).get();
        employee.setActive(false);
        employeeRepository.save(employee);
        EmployeeDto employeeDto = modelMapperManager.forResponse().map(employee,EmployeeDto.class);
        DeleteEmployeeVm deleteEmployeeVm = modelMapperManager.forResponse().map(employeeDto, DeleteEmployeeVm.class);
        return deleteEmployeeVm;
    }

   
}
