package com.hyva.idm.pkt.pktRepositories;

import com.hyva.idm.pkt.pktRelations.PktFields;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * krishna
 */
@Repository
public interface PktFieldRepository extends JpaRepository<PktFields,Long> {
    PktFields findByTableName(String table);

    List<PktFields> findAllByStatusAndId(String status, com.hyva.idm.sass.sassentities.PktFields Id);
    List<PktFields>  findAllByStatusAndIdAndGroupOfIsNull(String status, com.hyva.idm.sass.sassentities.PktFields Id);
    //    List<PktFields> findAllByStatusAndGroupOf(String saasStatus,  PktFields Id);
    List<PktFields> findAllByStatusAndGroupOfAndTableNameNotIn(String saasStatus, com.hyva.idm.sass.sassentities.PktFields Id, List<String> list);
    List<PktFields> findAllByStatusAndGroupOfOrGroupOf(String saasStatus, String s, String ss);
    List<PktFields> findAllByFieldNameAndStatus(String Name, String status);
    //    List<PktFields> findAllByTableNameAndStatus(String Name,String Status);
    List<PktFields> findAllByTableNameAndStatusAndFieldNameNotNull(String Name, String Status);

    List<PktFields> findAllByTableNameAndStatus(String Name, String Status);

    List<PktFields> findAllByStatusAndGroupOfAndFieldNameNotIn(String status, String groupof, List<String> list);
//    List<PktFields> findAllByStatusAndTableNameAndFieldNameNotIn(String status,List<String> list);


    List<PktFields> findAllByStatus(String saasStatus);
    List<PktFields> findAllByTableNameAndStatusAndFieldNameNotIn(String status, String groupof, List<String> lis);

    //##Duplicate Table Name
    List<PktFields> findAllByFieldNameAndGroupOfAndStatusAndTableNameNotIn(String ss, String dd, String status, List<String> list);
    List<PktFields> findAllByFieldNameOrFieldNameAndGroupOfOrGroupOfAndStatusAndTableNameNotIn(String nn, String ee, String nnn, String e, String status, List<String> list);
    List<PktFields> findAllByFieldNameOrFieldNameAndGroupOfOrGroupOfAndStatus(String nn, String ee, String nnn, String e, String status);
    List<PktFields> findAllByFieldNameAndGroupOfAndStatus(String ss, String dd, String status);
    PktFields findByFieldNameAndGroupOfAndTableNameAndIdNotIn(String fieldsName, String groupof, String TableName, Long ID);
    PktFields findByFieldNameAndGroupOfAndTableName(String fieldsName, String groupof, String TableName);
    List<PktFields> findByFieldNameNotNullAndGroupOfNotNullAndStatus(String status);
    List<PktFields>  findAllByTableName(String name);
}
