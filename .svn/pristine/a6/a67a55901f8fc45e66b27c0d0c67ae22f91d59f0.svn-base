package com.hyva.idm.endpoints;

import com.hyva.idm.constants.EndpointConstants;
import com.hyva.idm.entity.ModuleEntity;
import com.hyva.idm.pojo.IDMResponse;
import com.hyva.idm.pojo.ModulePojo;
import com.hyva.idm.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by tnataraj on 1/20/18.
 */
@RestController
@RequestMapping(EndpointConstants.MODULE_ENDPOINT)
public class ModuleEndpoint {

    @Autowired
    ModuleService moduleService;

    @RequestMapping(value = "/createModule",method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse createModule(@Validated @RequestBody ModulePojo modulePojo)
    {
        return moduleService.createModule(modulePojo);
    }

    @RequestMapping(value = "/updateModule/{moduleId}",method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse updateModule(@PathVariable("moduleId") Long moduleId,
                                    @Validated @RequestBody ModulePojo modulePojo)
    {
        return moduleService.updateModule(moduleId,modulePojo);
    }

    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ModuleEntity> getAllModules()
    {
        return moduleService.getAllModules();
    }



}
