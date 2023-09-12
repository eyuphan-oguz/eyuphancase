package com.eyuphancase.eyuphancase.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eyuphancase.eyuphancase.exception.company.CompanyAlreadyExistsException;
import com.eyuphancase.eyuphancase.exception.company.CompanyMethodArgumentNotValidException;
import com.eyuphancase.eyuphancase.exception.company.CompanyNotFoundException;
import com.eyuphancase.eyuphancase.model.dto.CompanyDto;
import com.eyuphancase.eyuphancase.model.entity.Company;
import com.eyuphancase.eyuphancase.model.vm.Company.AddCompanyVm;
import com.eyuphancase.eyuphancase.model.vm.Company.DeleteCompanyVm;
import com.eyuphancase.eyuphancase.model.vm.Company.GetAllCompanyVm;
import com.eyuphancase.eyuphancase.model.vm.Company.GetCompanyVm;
import com.eyuphancase.eyuphancase.model.vm.Company.UpdateCompanyVm;
import com.eyuphancase.eyuphancase.repository.CompanyRepository;
import com.eyuphancase.eyuphancase.service.CompanyService;
import com.eyuphancase.eyuphancase.util.mapper.ModelMapperManager;

@Service
public class CompanyServiceImpl implements CompanyService{
    
    private ModelMapperManager modelMapperManager;
    private CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImpl(ModelMapperManager modelMapperManager, CompanyRepository companyRepository) {
        this.modelMapperManager = modelMapperManager;
        this.companyRepository = companyRepository;
    }

    @Override
    public AddCompanyVm addCompanyVm(AddCompanyVm addCompanyVm) {
        List<Company> companies = companyRepository.findByNameIgnoreCase(addCompanyVm.getName());

       if (!companies.isEmpty()) {
        for (Company company : companies) {
            if (!company.isActive()) {
                company.setActive(true);
                companyRepository.save(company);
            } else {
                throw new CompanyAlreadyExistsException("Bu şirket sisteme zaten kayıtlı!!!");
            }
        }
    }

    else if (addCompanyVm.getName().length() <= 3 || addCompanyVm.getName().length() >= 100) {
        throw new CompanyMethodArgumentNotValidException("Şirket adı minimum 3 maksimum 100 karakter olmalıdır.");
    }

    else{
        CompanyDto companyDto = modelMapperManager.forRequest().map(addCompanyVm,CompanyDto.class);
        Company company = modelMapperManager.forRequest().map(companyDto, Company.class);
        companyRepository.save(company);
        }

        return addCompanyVm;
    }

    @Override
    public List<GetAllCompanyVm> getAllCompanyVm() {
         List<CompanyDto> companyDtos = companyRepository.findByActive(true).stream().map(company ->modelMapperManager.forResponse().map(company,CompanyDto.class)).collect(Collectors.toList());
        List<GetAllCompanyVm> getAllCompanyVms = companyDtos.stream().map(companyDto -> modelMapperManager.forResponse().map(companyDto, GetAllCompanyVm.class)).collect(Collectors.toList());
        return getAllCompanyVms;
    }

    @Override
    public GetCompanyVm getCompanyVm(Long id) {
        if(!existsById(id)){
            throw new CompanyNotFoundException("Veritabanında böyle bir kayıt bulunamadı.");
        }
        Company company = companyRepository.findByIdAndActiveTrue(id);
        CompanyDto companyDto = modelMapperManager.forResponse().map(company,CompanyDto.class);
        GetCompanyVm getCompanyVm = modelMapperManager.forResponse().map(companyDto, GetCompanyVm.class);

        return getCompanyVm;
    }

    @Override
    public boolean existsById(Long id) {
        return companyRepository.existsByIdAndActiveTrue(id) ? true : false;
    }

    @Override
    public DeleteCompanyVm deleteCompanyVm(Long id) {
       if(!existsById(id)){
            throw new CompanyNotFoundException("Veritabanıda böyle bir kayıt bulunamadı.");
        }
        Company company = companyRepository.findById(id).get();
        company.setActive(false);
        companyRepository.save(company);
        CompanyDto companyDto = modelMapperManager.forResponse().map(company,CompanyDto.class);
        DeleteCompanyVm deleteCompanyVm = modelMapperManager.forResponse().map(companyDto, DeleteCompanyVm.class);
        return deleteCompanyVm;
    }

    @Override
    public UpdateCompanyVm updateCompanyVm(Long id, UpdateCompanyVm updateCompanyVm) {
        List<Company> companies = companyRepository.findByNameIgnoreCase(updateCompanyVm.getName());
        if (!companies.isEmpty()) {     
            throw new CompanyAlreadyExistsException("Bu şirket adıyla eşleşen kayıt sistemde zaten mevcut ve aktif.");
                
        }

        else if(!existsById(id)){
            throw new CompanyNotFoundException("Verıtabanında böyle bir kayıt bulunamadı.");
        }
        
        Company company = companyRepository.findById(id).get();
        company.setName(updateCompanyVm.getName());
        companyRepository.save(company);
        return updateCompanyVm;
    }

    

    
}
