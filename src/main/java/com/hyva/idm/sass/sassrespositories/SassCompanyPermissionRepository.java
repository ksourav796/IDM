package com.hyva.idm.sass.sassrespositories;

import com.hyva.idm.sass.sassentities.CompanyPermission;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SassCompanyPermissionRepository extends CrudRepository<CompanyPermission, Long> {
}
