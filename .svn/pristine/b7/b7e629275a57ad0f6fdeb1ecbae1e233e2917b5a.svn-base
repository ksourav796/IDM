package com.hyva.idm.mapper;

import com.hyva.idm.entity.CompanyEntity;
import com.hyva.idm.pojo.CompanyPojo;

import java.util.function.Function;

/**
 * Created by tnataraj on 1/15/18.
 */
public class CompanyMapper {

  public static   Function<CompanyPojo, CompanyEntity> pojoToEntity
            = new Function<CompanyPojo, CompanyEntity>() {
        public CompanyEntity apply(CompanyPojo pojo) {
            CompanyEntity companyEntity = new CompanyEntity();
            companyEntity.setActive(Boolean.TRUE);
            companyEntity.setEmailId(pojo.getEmailId());
            companyEntity.setCompanyName(pojo.getCompanyName());
            companyEntity.setSaasToken(pojo.getSaasToken());
            companyEntity.setKeyWord(pojo.getKeyWord());
            companyEntity.setCompanyType(pojo.getCompanyType());
            return companyEntity;
        }
    };
}
