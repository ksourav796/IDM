package com.hyva.idm.sass.sassrespositories;

import com.hyva.idm.sass.sassentities.CartCustomerLink;
import com.hyva.idm.sass.sassentities.Cartregistration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CartCustomerRepository extends CrudRepository<CartCustomerLink, Long> {
    CartCustomerLink findByEmail(String email);
    CartCustomerLink findByCartCustId(Long cartCustId);
    CartCustomerLink findByClientIdAndCartId(String clientId, Cartregistration cartregistration);

}
