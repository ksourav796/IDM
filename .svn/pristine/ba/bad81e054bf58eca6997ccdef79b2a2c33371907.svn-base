package com.hyva.idm.respositories;

import com.hyva.idm.entity.CompanyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by tnataraj on 1/15/18.
 */
@Repository
public interface CompanyRepository extends CrudRepository<CompanyEntity, Long> {

  public CompanyEntity findByCompanyName(String companyName);


}
