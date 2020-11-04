package com.hyva.idm.sass.sassrespositories;

import com.hyva.idm.sass.sassentities.CustomerNotifications;
import com.hyva.idm.sass.sassentities.SassCustomer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SassCustomerRepository extends CrudRepository<SassCustomer, Long> {
    SassCustomer findByEmailAndLoginNameAndLoginPassword(String Email,String LoginName,String LoginPassword);
    SassCustomer findByEmailAndLoginUniqueId(String Email,String LoginUniqueId);
    boolean  existsByEmail(String Email);
    List<SassCustomer> findByCustomerNameIsStartingWith(String CompanyName);
    SassCustomer findByEmail(String Email);
    List<SassCustomer> findAllByEmailStartsWith(String Email);
    SassCustomer findDistinctByCustomerName(String customerName);
    SassCustomer findByCustomerName(String customerName);
    SassCustomer findAllByEmail(String email);

     SassCustomer findByCustomerId(Long id);

    static void save(CustomerNotifications customerNotifications) {

    }
}
