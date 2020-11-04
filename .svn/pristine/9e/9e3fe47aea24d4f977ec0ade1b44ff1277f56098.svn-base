package com.hyva.idm.mapper;

import com.hyva.idm.entity.ModuleEntity;
import com.hyva.idm.pojo.ModulePojo;

/**
 * Created by tnataraj on 1/20/18.
 */
public class ModuleMapper {

    public static ModuleEntity mapPojoToEntity(ModulePojo modulePojo){

        ModuleEntity moduleEntity=new ModuleEntity();
        moduleEntity.setDescription(modulePojo.getDescription());
        moduleEntity.setModuleName(modulePojo.getModuleName());
        moduleEntity.setUrlPrefix(modulePojo.getUrlPrefix());
        return moduleEntity;
    }

    public static ModulePojo mapEntityToPojo(ModuleEntity moduleEntity){
        ModulePojo modulePojo=new ModulePojo();
        modulePojo.setDescription(moduleEntity.getDescription());
        modulePojo.setUrlPrefix(moduleEntity.getUrlPrefix());
        modulePojo.setModuleName(moduleEntity.getModuleName());
        return modulePojo;

    }


}
