package com.hyva.idm.respositories;

import com.hyva.idm.entity.ModuleEntity;
import com.hyva.idm.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Created by tnataraj on 1/20/18.
 */
@Repository
public interface ModuleRepository extends CrudRepository<ModuleEntity, Long> {
    UserEntity findByModuleName(String moduleName);

    Set<ModuleEntity> findByIdIn(Long ids[]);
}
