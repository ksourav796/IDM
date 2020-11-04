package com.hyva.idm.sass.sassmapper;

import com.hyva.idm.sass.sassentities.RTRSyncSettings;
import com.hyva.idm.sass.sasspojo.RTRSyncSettingsPojo;

public class RTRSyncSettingsMapper {
    public static RTRSyncSettings mapPojoToEntity(RTRSyncSettingsPojo pojo){
        RTRSyncSettings rtrSyncSettings=new RTRSyncSettings();
        rtrSyncSettings.setRtrSyncID(pojo.getRtrSyncID());
        rtrSyncSettings.setCompanyKeyWord(pojo.getCompanyKeyWord());
        rtrSyncSettings.setRtrSyncOption(pojo.getRtrSyncOption());
        rtrSyncSettings.setRtrSyncSchedulePeriod(pojo.getRtrSyncSchedulePeriod());
        rtrSyncSettings.setRtrSyncType(pojo.getRtrSyncType());
        rtrSyncSettings.setCreatedAt(pojo.getCreatedAt());
        rtrSyncSettings.setUpdatedAt(pojo.getUpdatedAt());
        rtrSyncSettings.setRtrSyncStatus(pojo.getRtrSyncStatus());
        return rtrSyncSettings;
    }
}
