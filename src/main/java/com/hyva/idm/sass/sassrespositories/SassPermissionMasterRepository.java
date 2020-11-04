package com.hyva.idm.sass.sassrespositories;
import com.hyva.idm.sass.sassentities.PermissionMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SassPermissionMasterRepository extends CrudRepository<PermissionMaster,Long> {


    PermissionMaster  getPermissionMasterByDescription(String description);

    List<PermissionMaster> findAllBySaasStatusAndAndParentPM(String saasStatus,  PermissionMaster parentPM);
PermissionMaster findByPmId(Long pmId);
}
