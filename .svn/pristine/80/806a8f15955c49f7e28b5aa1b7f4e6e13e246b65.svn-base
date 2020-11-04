package com.hyva.idm.service;

import com.hyva.idm.entity.ModuleEntity;
import com.hyva.idm.entity.UserEntity;
import com.hyva.idm.exceptions.NotFoundException;
import com.hyva.idm.mapper.ModuleMapper;
import com.hyva.idm.messages.ErrorMessages;
import com.hyva.idm.messages.SuccessMessages;
import com.hyva.idm.pojo.IDMResponse;
import com.hyva.idm.pojo.ModulePojo;
import com.hyva.idm.respositories.ModuleRepository;
import com.hyva.idm.respositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by tnataraj on 1/20/18.
 */
@Service
public class ModuleService {
    @Autowired
    ModuleRepository moduleRepository;

    @Autowired
    UserRepository userRepository;

    @Transactional
    public IDMResponse createModule(ModulePojo modulePojo) {
        moduleRepository.save(ModuleMapper.mapPojoToEntity(modulePojo));
        IDMResponse idmResponse = new IDMResponse(HttpStatus.OK.value(), SuccessMessages.MODULE_CREATED);
        idmResponse.setObject(modulePojo);
        return idmResponse;
    }

    public IDMResponse updateModule(Long moduleId, ModulePojo modulePojo) {
        ModuleEntity moduleEntity = moduleRepository.findOne(moduleId);
        if (moduleEntity == null) {

            throw new NotFoundException(HttpStatus.NOT_FOUND.value(), ErrorMessages.MODULE_NOT_FOUND);
        }
        moduleEntity.setModuleName(modulePojo.getModuleName());
        moduleEntity.setUrlPrefix(modulePojo.getUrlPrefix());
        moduleEntity.setDescription(modulePojo.getDescription());
        IDMResponse idmResponse = new IDMResponse(HttpStatus.OK.value());
        idmResponse.setObject(modulePojo);
        return idmResponse;
    }

    public List<ModuleEntity> getAllModules() {
        Iterable<ModuleEntity> moduleEntities = moduleRepository.findAll();
        List<ModuleEntity> modulePojos = new ArrayList<>();
        moduleEntities.forEach(moduleEntity -> {
            modulePojos.add(moduleEntity);

        });
        return modulePojos;
    }

    @Transactional
    public List<ModulePojo> addUserRights(Long moduleIds[], long userId) {

        Set<ModuleEntity> moduleEntities = moduleRepository.findByIdIn(moduleIds);
        UserEntity userEntity = userRepository.findOne(userId);
        userEntity.getModuleEntitySet().addAll(moduleEntities);
        userRepository.save(userEntity);
        List<ModulePojo> modulePojos;
        modulePojos = userEntity.getModuleEntitySet().stream().map(moduleEntity ->
                ModuleMapper.mapEntityToPojo(moduleEntity)).collect(Collectors.toList());
        return modulePojos;
    }


    @Transactional
    public List<ModulePojo> removeUserRights(Long moduleIds[], long userId) {
        List moduleIdList = Arrays.asList(moduleIds);
        UserEntity userEntity = userRepository.findOne(userId);
          for (Iterator<ModuleEntity> it = userEntity.getModuleEntitySet().iterator(); it.hasNext();) {
            ModuleEntity moduleEntity=it.next();
            if (moduleIdList.contains(moduleEntity.getId())){
                it.remove();
            }
        }
        userRepository.save(userEntity);
        List<ModulePojo> modulePojos;
        modulePojos = userEntity.getModuleEntitySet().stream().map(moduleEntity ->
                ModuleMapper.mapEntityToPojo(moduleEntity)).collect(Collectors.toList());
        return modulePojos;
    }


}
