package com.hyva.idm.endpoints;

import com.hyva.idm.constants.EndpointConstants;
import com.hyva.idm.pojo.ModulePojo;
import com.hyva.idm.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by tnataraj on 1/20/18.
 */
@RestController
@RequestMapping(EndpointConstants.USER_RIGHTS_ENDPOINT)
public class UserRightsEndpoint {

    @Autowired
    ModuleService moduleService;

    @RequestMapping(value = "/add_user_rights/{userId}",method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ModulePojo> add(@RequestBody Long moduleIds[], @PathVariable("userId") Long userId) {
        return moduleService.addUserRights(moduleIds,userId);
    }


    @RequestMapping(value = "/remove_user_rights/{userId}",method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ModulePojo> removeModulePermission(@RequestBody Long moduleIds[], @PathVariable("userId") Long userId) {
        return moduleService.removeUserRights(moduleIds,userId);
    }
}
