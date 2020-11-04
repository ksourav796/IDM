package com.hyva.idm.endpoints;

import com.hyva.idm.constants.EndpointConstants;
import com.hyva.idm.pojo.IDMResponse;
import com.hyva.idm.pojo.UserPojo;
import com.hyva.idm.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by tnataraj on 1/6/18.
 */
@RestController
@RequestMapping(EndpointConstants.USER_ENDPOINT)
public class UserEndpoint {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "/createUser",method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse createUser(@Validated @RequestBody UserPojo userPojo) {
        return userService.createUser(userPojo);
    }

    @RequestMapping(value="/user", method = RequestMethod.GET)
    public List listUser(){
        return userService.findAll();
    }

    @RequestMapping(value = "/change_password", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse changePassword(@RequestParam("oldPassword") String oldPassword,
                                      @RequestParam("userName") String userName,
                                      @RequestParam("newPassword") String newPassword)
    {
        return userService.changepassword(userName,oldPassword,newPassword);
    }


//    @RequestMapping(value = "/reset_password", method = RequestMethod.POST,
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    public String resetPassword() {
//        return "reset password";
//    }


    @RequestMapping(method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse deleteUser(@RequestParam("userName") String userName)
    {
        return userService.deleteUser(userName);
    }

}
