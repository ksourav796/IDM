package com.hyva.idm.sass.sassrespositories;

import com.hyva.idm.sass.sassentities.PermissionMaster;
import com.hyva.idm.sass.sassentities.PktFields;
import com.hyva.idm.sass.sassentities.SassCurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SassPktfieldsRepository extends JpaRepository<PktFields, Long> {
    PktFields findByTableName(String table);

    List<PktFields>  findAllByStatusAndId(String status,PktFields Id);
    List<PktFields>  findAllByStatusAndIdAndGroupOfIsNull(String status,PktFields Id);
//    List<PktFields> findAllByStatusAndGroupOf(String saasStatus,  PktFields Id);
    List<PktFields> findAllByStatusAndGroupOfAndTableNameNotIn(String saasStatus,  PktFields Id,List<String> list);
    List<PktFields> findAllByStatusAndGroupOfOrGroupOf(String saasStatus,  String s,String ss);
    List<PktFields> findAllByFieldNameAndStatus(String Name,String status);
//    List<PktFields> findAllByTableNameAndStatus(String Name,String Status);
    List<PktFields> findAllByTableNameAndStatusAndFieldNameNotNull(String Name,String Status);

List<PktFields> findAllByTableNameAndStatus(String Name,String Status);

    List<PktFields> findAllByStatusAndGroupOfAndFieldNameNotIn(String status,String groupof,List<String> list);
//    List<PktFields> findAllByStatusAndTableNameAndFieldNameNotIn(String status,List<String> list);


    List<PktFields> findAllByStatus(String saasStatus);
    List<PktFields> findAllByTableNameAndStatusAndFieldNameNotIn(String status,String groupof,List<String> lis);

//##Duplicate Table Name
   List<PktFields> findAllByFieldNameAndGroupOfAndStatusAndTableNameNotIn(String ss,String dd,String status,List<String> list);
   List<PktFields> findAllByFieldNameOrFieldNameAndGroupOfOrGroupOfAndStatusAndTableNameNotIn(String nn,String ee,String nnn,String e,String status,List<String> list);
   List<PktFields> findAllByFieldNameOrFieldNameAndGroupOfOrGroupOfAndStatus(String nn,String ee,String nnn,String e,String status);
    List<PktFields> findAllByFieldNameAndGroupOfAndStatus(String ss,String dd,String status);
    PktFields findByFieldNameAndGroupOfAndTableNameAndIdNotIn(String fieldsName,String groupof,String TableName,Long ID);
    PktFields findByFieldNameAndGroupOfAndTableName(String fieldsName,String groupof,String TableName);
}
