package com.hyva.idm.sass.sassrespositories;

import com.hyva.idm.sass.sassentities.Webpermission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface webPermissionRepository  extends JpaRepository<Webpermission,Long>{
    List<Webpermission> findAllByApplicationNameAndTableNameAndPageName(String appNme,String tableName,String pageName);
}
