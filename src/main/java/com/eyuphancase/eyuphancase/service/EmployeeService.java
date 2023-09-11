package com.eyuphancase.eyuphancase.service;

import java.util.List;

import com.eyuphancase.eyuphancase.model.vm.Employee.AddEmployeeVm;
import com.eyuphancase.eyuphancase.model.vm.Employee.DeleteEmployeeVm;
import com.eyuphancase.eyuphancase.model.vm.Employee.GetAllEmployeeVm;
import com.eyuphancase.eyuphancase.model.vm.Employee.GetEmployeeVm;
import com.eyuphancase.eyuphancase.model.vm.Employee.UpdateEmployeeVm;

public interface EmployeeService {
    
    AddEmployeeVm addEmployeeVm(AddEmployeeVm addEmployeeVm);

    List<GetAllEmployeeVm> getAllEmployeeVm();

    GetEmployeeVm getEmployeeVm(Long id);

    boolean existsById(Long id);

    DeleteEmployeeVm deleteEmployeeVm(Long id);

    UpdateEmployeeVm updateEmployeeVm(Long id,UpdateEmployeeVm updateEmployeeVm);

}
