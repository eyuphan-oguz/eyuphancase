package com.eyuphancase.eyuphancase.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eyuphancase.eyuphancase.model.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long>{

    List<Company> findByNameIgnoreCase(String name);

    List<Company> findByActive(boolean active);

    Company findByIdAndActiveTrue(Long id);

    boolean existsByIdAndActiveTrue(Long id);
}
