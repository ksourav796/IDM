package com.hyva.idm.sass.sassservice;
import com.hyva.idm.sass.sassentities.CompanyPermission;
import com.hyva.idm.sass.sassentities.PermissionGroup;
import com.hyva.idm.sass.sassentities.PermissionMaster;
import com.hyva.idm.sass.sasspojo.PermissionMasterDTO;
import com.hyva.idm.sass.sassrespositories.SassCompanyPermissionRepository;
import com.hyva.idm.sass.sassrespositories.SassPermissionGroupRepository;
import com.hyva.idm.sass.sassrespositories.SassPermissionMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Date;
@Component
public class SassPermissionMasterService {

    @Autowired
    SassPermissionMasterRepository sassPermissionMasterRepository;
    @Autowired
    SassPermissionGroupRepository sassPermissionGroupRepository;
    @Autowired
    SassCompanyPermissionRepository sassCompanyPermissionRepository;

    public PermissionGroup getpermissionMasterGroupMaster(String featureName) {
        PermissionGroup permissionGroup = sassPermissionGroupRepository.getPermissionGroupByFeatureName(featureName);
        return permissionGroup;
    }

    public PermissionMaster getpermissionMasterMaster(String level1) {

        PermissionMaster permissionMaster = sassPermissionMasterRepository.getPermissionMasterByDescription(level1);
        return permissionMaster;
    }


    public PermissionMasterDTO NewpermissionMaster(PermissionMasterDTO permission) {
        PermissionMaster pmaster = null;
        CompanyPermission companyPermission=null;
        PermissionGroup pgroup = sassPermissionGroupRepository.findOne(permission.getPgId());
        if (permission.getPmId() != null) {
            pmaster = sassPermissionMasterRepository.findOne(permission.getPmId());
        }
        if (permission.getLevel2() != null) {
            pmaster = sassPermissionMasterRepository.findOne(permission.getLevel2());
        }
//        else {
//            pmaster = sassPermissionMasterRepository.findOne(permission.getPmId());
////        }
            PermissionMasterDTO master = saveNewpermissionmaster(permission, pgroup, pmaster);
            return master;
    }


        public PermissionMasterDTO saveNewpermissionmaster(PermissionMasterDTO newpermissionmaster, PermissionGroup pgroup, PermissionMaster pmaster) {
        PermissionMaster group = new PermissionMaster();
        CompanyPermission companyPermission=new CompanyPermission();
        group.setPermissionGroupId(pgroup);
        if (pmaster != null) {
            group.setParentPM(pmaster);
            companyPermission.setPermissionMasterId(pmaster);
        }
        // group.setPmId(newpermissionmaster.getPmId());
        group.setDescription(newpermissionmaster.getDescription());
        group.setSaasStatus(newpermissionmaster.getSaasStatus());
        group.setPermissionMasterkey(newpermissionmaster.getPermissionMasterkey());
      PermissionMaster permissionMaster  =sassPermissionMasterRepository.save(group);
            companyPermission.setPermissionMasterkey(newpermissionmaster.getPermissionMasterkey());
            companyPermission.setDescription(newpermissionmaster.getDescription());
            companyPermission.setFromDate(new Date());
            companyPermission.setToDate(new Date());
            companyPermission.setValidity(2);
            companyPermission.setValidityRemaining(2);
            companyPermission.setStatus(newpermissionmaster.getSaasStatus());
            companyPermission.setPermissionMasterId(permissionMaster);
            sassCompanyPermissionRepository.save(companyPermission);
        return newpermissionmaster;
    }
}
