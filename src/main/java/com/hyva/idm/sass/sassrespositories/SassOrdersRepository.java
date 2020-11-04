package com.hyva.idm.sass.sassrespositories;

import com.hyva.idm.sass.sassentities.SassOrders;
import com.hyva.idm.sass.sassentities.SassSubscriptions;
import com.hyva.idm.sass.sassentities.SassUser;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SassOrdersRepository  extends JpaRepository<SassOrders, Long> {
//    public SassOrders findByOrdersName(String newsletter);
        SassOrders getSassOrdersByLicenceKey(String LicenceKey);
        List<SassOrders> findByCompanyEmail(String Email);
        List<SassOrders> findBySassOrdersId(Long id);
        List<SassOrders> findByCompanyNameIsStartingWith(String CompanyName);
        SassOrders findByLoginUniqueId(String loginUniqueId);
        SassOrders getSassOrdersByLoginUniqueId(String loginUniqueId);
        SassOrders getByPasswordIn(String password);
        List<SassOrders> findBySassUserId(SassUser userId);
        SassOrders findAllBySassOrdersId(Long id);
        SassOrders findBySassSubscriptionsId(Long id);

        SassOrders findByCompanyName(String companyName);
       List<SassOrders>findAllByCompanyNameContainingOrCompanyEmailContainingOrCustomerNameContainingOrCompanyPhoneContainingOrPostingStatusContaining(String companyName, String email, String name, String phone,String status);
       List<SassOrders> findByCompanyNameContainingOrCompanyEmailContainingOrCustomerNameContainingOrCompanyPhoneContainingOrPostingStatusContaining(String companyName, String email, String name, String phone,String status,Pageable pageable);
       SassOrders findFirstByCompanyNameContainingOrCompanyEmailContainingOrCustomerNameContainingOrCompanyPhoneContainingOrPostingStatusContaining(String companyName, String email, String name, String phone,String status,Sort sort);
       SassOrders findFirstByCompanyName(String companyName, Sort sort);
        List<SassOrders>findAllByCompanyName(String companyName, Pageable pageable);
        SassOrders findFirstBy(Sort sort);
        List<SassOrders>findAllBy(Pageable pageable);
        SassOrders findByCompanyEmailAndUsernameAndPasswordAndPostingStatus(String email,String username,String password,String status);
        SassOrders findAllByCompanyEmailAndPostingStatus(String email,String status);
        List<SassOrders> findBySassCustomer(Long id);
        SassOrders findByDeveloperId(String id);
        List<SassOrders> findAllByDeveloperId(String id);

        List<SassOrders> findBySassSubscriptionsId(SassSubscriptions sassSubscriptions);
        }
