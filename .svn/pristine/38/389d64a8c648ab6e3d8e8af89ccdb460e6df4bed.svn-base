package com.hyva.idm.sass.sassrespositories;

import com.hyva.idm.sass.sassentities.WebsitePermissions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebsitePermissionsRepository  extends JpaRepository<WebsitePermissions,Long>{
    WebsitePermissions findAllByTableNameAndApplicationId(String tableName,String applicationName);
}
