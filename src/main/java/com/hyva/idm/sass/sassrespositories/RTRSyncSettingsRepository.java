package com.hyva.idm.sass.sassrespositories;

import com.hyva.idm.sass.sassentities.RTRSyncSettings;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RTRSyncSettingsRepository extends CrudRepository<RTRSyncSettings, Long> {
    List<RTRSyncSettings>findByCompanyKeyWordStartingWith(String companyKeyword);
}
