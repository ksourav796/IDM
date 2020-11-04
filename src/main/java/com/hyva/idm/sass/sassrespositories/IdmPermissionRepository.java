package com.hyva.idm.sass.sassrespositories;

import com.hyva.idm.sass.sassentities.IdmPermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdmPermissionRepository extends JpaRepository<IdmPermission,Long> {
   IdmPermission findByIdmpermissionId(Long id);
   IdmPermission findByUserId(Long userid);
}
