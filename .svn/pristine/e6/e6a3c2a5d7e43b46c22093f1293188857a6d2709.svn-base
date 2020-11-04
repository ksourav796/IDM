package com.hyva.idm.sass.sassrespositories;

import com.hyva.idm.sass.sassentities.CustomerNotifications;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SassCustomerNotificationsRepository extends JpaRepository<CustomerNotifications, Long>, JpaSpecificationExecutor {
    List<CustomerNotifications> findByTypeFlagOrTypeFlagOrTypeFlagAndToRegnoAndStatus(String subcriptiontype, String restaurantType, String subscriptionSales, String toReg, String status);

    List<CustomerNotifications> findByTypeFlagAndToRegnoAndStatus(String typeFlag, String toReg, String status);

    List<CustomerNotifications> findByToRegno(String fromRegno);

    List<CustomerNotifications> findByFromRegnoAndSubscriptionTypeAndViewStatus(String fromRegno, String subscriptionType, String viewStatus);

    CustomerNotifications findByFromRegnoAndToRegnoAndTypeDoc(String typeDoc, String fromRegNo, String toRegNO);

    List<CustomerNotifications> findAllByTypeDoc(String typedoc);

    CustomerNotifications findAllByCustNotiId(Long id);

    List<CustomerNotifications> findAllByRestaurantIdAndStatus(String restaurantId, String status, Sort sort);

    CustomerNotifications findAllByCustomerNotification(String id);

    List<CustomerNotifications> findAllByRestaurantId(String restaurantId);

    @Query("select cn from CustomerNotifications as cn where cn.restaurantId=:restaurantId and (cn.notificationId=:notificationId or cn.objectdata like :customerNo or cn.objectdata like :customerName)")
    List<CustomerNotifications> findAllBy(@Param(value = "restaurantId") String restaurantId, @Param(value = "notificationId") Long notificationId, @Param(value = "customerName") String customerName, @Param(value = "customerNo") String customerNo);

    CustomerNotifications findFirstBy(Sort sort);

    List<CustomerNotifications> findAllBy(Pageable pageable);

    @Query("SELECT  DISTINCT restaurantName FROM CustomerNotifications as cn")
    List<String> findDistinctByRestaurantName();

}
