package com.hyva.idm.sass.sassrespositories;

import com.hyva.idm.sass.sassentities.SassOrders;
import com.hyva.idm.sass.sassentities.SassSubscriptions;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SassSubscriptionRepository extends JpaRepository<SassSubscriptions, Long> {


//    List<SassSubscriptions> findBySubscriptionName(String subscriptionName);

    SassSubscriptions findBySubscriptionId(Long subscriptionId);
    SassSubscriptions findBySubscriptionName(String SubscriptionName );
    SassSubscriptions findBySubscriptionNameAndVersion(String SubscriptionName,String version );
    List<SassSubscriptions> getBySubscriptionId(Long subscriptionId);
   List<SassSubscriptions>  findAllBySubscriptionNameContaining(String SubscriptionName );
    List<SassSubscriptions> findAllBySubscriptionNameContaining(String typeName, Pageable pageable);
    SassSubscriptions findFirstBySubscriptionNameContaining(String typeName, Sort sort);
    SassSubscriptions findFirstBy(Sort sort);
    List<SassSubscriptions> findAllBy(Pageable pageable);
    List<SassSubscriptions> findAllBySubscriptionForAndStatus(String subscription,String status);
    List<SassSubscriptions> findBySubscriptionForIsNotLikeAndStatus(String subscription,String status);
    SassSubscriptions findAllBySubscriptionForAndSubscriptionNameAndVersionAndSubscriptionIdNotIn(String subscriptionfor,String subscriptionname,String version,Long Id);
    SassSubscriptions findAllBySubscriptionForAndSubscriptionNameAndVersion(String subscriptionfor,String subscriptionname,String version);
    // List<SassSubscriptions> findByUsers(String Users);
    List<SassSubscriptions> findByDeveloperId(String id);
   List<SassSubscriptions> findByStatus(String status);
}
