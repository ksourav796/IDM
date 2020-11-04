package com.hyva.idm.service;

import com.hyva.idm.entity.CompanyEntity;
import com.hyva.idm.mapper.CompanyMapper;
import com.hyva.idm.pojo.CompanyPojo;
import com.hyva.idm.pojo.IDMResponse;
import com.hyva.idm.respositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by tnataraj on 1/15/18.
 */
@Component
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    @Transactional
    public IDMResponse createCompany(CompanyPojo companyPojo) {

        CompanyEntity companyEntity = CompanyMapper.pojoToEntity.apply(companyPojo);
        companyRepository.save(companyEntity);
        return new IDMResponse(HttpStatus.OK.value(), "success");
    }

    @Transactional
    public IDMResponse deleteCompany(String companyName) {

        CompanyEntity companyEntity = companyRepository.findByCompanyName(companyName);
        companyEntity.setActive(Boolean.FALSE);
        return new IDMResponse(HttpStatus.OK.value(), "Delete success");
    }




}
