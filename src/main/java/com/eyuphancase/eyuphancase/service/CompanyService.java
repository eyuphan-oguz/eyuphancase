package com.eyuphancase.eyuphancase.service;

import java.util.List;

import com.eyuphancase.eyuphancase.model.vm.Company.AddCompanyVm;
import com.eyuphancase.eyuphancase.model.vm.Company.DeleteCompanyVm;
import com.eyuphancase.eyuphancase.model.vm.Company.GetAllCompanyVm;
import com.eyuphancase.eyuphancase.model.vm.Company.GetCompanyVm;
import com.eyuphancase.eyuphancase.model.vm.Company.UpdateCompanyVm;


public interface CompanyService {
    
    AddCompanyVm addCompanyVm(AddCompanyVm addCompanyVm);

    List<GetAllCompanyVm> getAllCompanyVm();

    GetCompanyVm getCompanyVm(Long id);

    boolean existsById(Long id);

    DeleteCompanyVm deleteCompanyVm(Long id);

    UpdateCompanyVm updateCompanyVm(Long id, UpdateCompanyVm updateCompanyVm);
}
