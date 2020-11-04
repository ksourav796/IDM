package com.hyva.idm.sass.sassrespositories;

import com.hyva.idm.sass.sassentities.PktPermission;
import com.hyva.idm.sass.sasspojo.PktPermissionPojo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by krishna.
 */
@Repository
public interface PktRepository extends JpaRepository<PktPermission,Long> ,JpaSpecificationExecutor{

    List<PktPermission> findAllByKeyNameAndStatus(String Name,String status);
    List<PktPermission> findAllByKeyGroupOrKeyGroupAndKeySubscriptionAndStatus(String nn ,String ee,String subscition,String status);
    List<PktPermission> findAllByKeyValueAndStatus(String Name,String Status);
    List<PktPermission> findAllByKeyName(String Name);
    List<PktPermission> findAllByStatus(String status,Pageable pageable);
    PktPermission findFirstByStatus(String status,Sort sort);
//    PktPermission findAllByStatusAndKeyValueAndKeySubscription(String status,String KeyValue,String keySubscription);
    PktPermission findAllByStatusAndKeyValueAndKeySubscriptionAndKeyGroupIsNull(String status,String KeyValue,String keySubscription);
    List<PktPermission> findBykeyValue(String Name);
    List<PktPermission> findAllByKeySubscription(String subscription);
    List<PktPermission> findAllByTableNameNotNullAndColumnNameNotNullAndOperatorNotNull();
    List<PktPermission> findByKeySubscriptionAndTableNameAndColumnNameAndOperatorAndKeyNameAndKeyAction(String getKeySubscription,String getTableName,String getColumnName,String getOperator,String getKeyName,String KeyAction);
    List<PktPermission> findByKeySubscriptionAndTableNameAndColumnNameAndOperatorAndKeyNameAndKeyActionAndPktPermissionIdNotIn(String getKeySubscription,String getTableName,String getColumnName,String getOperator,String getKeyName,String KeyAction,Long ID);
    PktPermission findFirstByKeySubscriptionOrKeyNameOrKeyValue(String keyName,String subscription,String keyValue,Sort sort);
    List<PktPermission>findAllByKeySubscriptionContainingOrKeyNameOrKeyValue(String keyName,String keysubscription,String keyvalue,Pageable pageable);
    PktPermission findFirstBy(Sort sort);
    List<PktPermission>findByKeyGroup(String keyName,Pageable pageable);
    List<PktPermission>findAllByKeyGroup(String keyGroup);
    List<PktPermission>findAllByKeyGroupAndKeySubscription(String keyGroup,String keySubscription);
    List<PktPermission>findAllByKeySubscriptionContainingOrTableNameContainingOrKeyNameContainingOrColumnNameContainingOrOperatorContaining(String subscription,String tableName,String keyName,String columnName,String operator);
    PktPermission findFirstByKeySubscriptionContainingOrTableNameContainingOrKeyNameContainingOrColumnNameContainingOrOperatorContaining(String subscription,String tableName,String keyName,String columnName,String operator,Sort sort);
    List<PktPermission>findAllByKeySubscriptionContainingOrTableNameContainingOrKeyNameContainingOrColumnNameContainingOrOperatorContaining(String subscription,String tableName,String keyName,String columnName,String operator,Pageable pageable);
List<PktPermission>findAllBy(Pageable pageable);
    PktPermission findFirstByKeyNameOrKeySubscriptionOrKeyValue(String keyName, Sort sort,String subscription,String keyValue);
    List<PktPermission>findAllByKeyNameOrKeySubscriptionOrKeyValue(String keyName, Pageable pageable,String keysubscription,String keyvalue);


    List<PktPermission>findAllByKeySubscriptionOrKeyNameOrKeyValue(String keySubscription,String keyname,String keyvalue);
    @Query("from PktPermission where (keyName=:keyName and keySubscription=:keySubscription) or (keySubscription=:keySubscription and keyValue=:keyValue)")
    PktPermission findByKeyNameAndKeySubscription(@Param(value = "keyName") String keyName,@Param(value = "keySubscription") String keySubscription,@Param(value = "keyValue")  String keyValue);

    @Query("from PktPermission where (keyName=:keyName and keySubscription=:keySubscription and pktPermissionId  not like :id) or (keySubscription=:keySubscription and keyValue=:keyValue and pktPermissionId not like :id)")
    PktPermission findByKeyNameAndKeySubscriptionAndPktPermissionIdNotIn(@Param(value = "keyName") String keyName,@Param(value = "keySubscription") String keySubscription,@Param(value = "keyValue")  String keyValue,@Param(value = "id")Long id);

}
