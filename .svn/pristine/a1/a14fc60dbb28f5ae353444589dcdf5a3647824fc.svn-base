package com.hyva.idm.sass.sassrespositories;

import com.hyva.idm.sass.sassentities.SassCompany;
import com.hyva.idm.sass.sassentities.SassCountry;
import com.hyva.idm.sass.sassentities.SassCustomer;
import com.hyva.idm.sass.sassentities.SassOrders;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SassCompanyRepository extends CrudRepository<SassCompany, Long> {
    SassCompany findDistinctByCompanyEmailAndSassOrdersId(String Email,Long orderId);
    SassCompany findDistinctByLoginUniqueId(String sassToken);


    SassCompany findDistinctByCompanyEmailAndUsernameAndPassword(String Email,String username,String password);
    int countByParentCompanyRegNo(String cmpyRegNo);

    List<SassCompany> findByHiConnectCompnyRegNo(String fromRegno);

    List<SassCompany> findByCompanyNameStartingWith(String fromRegno);
    List<SassCompany> findByCompanyNameIsLike(String fromRegno);

    SassCompany getByHiConnectCompnyRegNo(String fromRegno);
    SassCompany findByLicenceKey(String licensekey);
    SassCompany findBySassOrdersId(SassOrders orderId);

}
