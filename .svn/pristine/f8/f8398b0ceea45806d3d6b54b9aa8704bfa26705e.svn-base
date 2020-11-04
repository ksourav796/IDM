package com.hyva.idm.sass.sassrespositories;

import com.hyva.idm.sass.sassentities.PermissionGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SassPermissionGroupRepository extends CrudRepository<PermissionGroup,Long> {


   PermissionGroup  getPermissionGroupByFeatureName(String featureName);
   PermissionGroup findByPgId(Long pgId);
}
