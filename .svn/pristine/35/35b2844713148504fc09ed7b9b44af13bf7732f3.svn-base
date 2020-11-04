    package com.hyva.idm.sass.sassendpoints;
import com.google.gson.Gson;
import com.hyva.idm.constants.EndpointConstants;
import com.hyva.idm.pojo.IDMResponse;
import com.hyva.idm.sass.sassentities.*;
import com.hyva.idm.sass.sasspojo.IdmPermissionPojo;
import com.hyva.idm.sass.sasspojo.PktUserPojo;
import com.hyva.idm.sass.sasspojo.SassUserPojo;
import com.hyva.idm.sass.sassrespositories.PositionTableRepository;
import com.hyva.idm.sass.sassrespositories.WebsitePermissionsRepository;
import com.hyva.idm.sass.sassservice.SassOrdersService;
import com.hyva.idm.sass.sassservice.SassUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServlet;
import java.lang.reflect.Type;
import java.util.List;


    /**
     * Created by azgar on 3/13/18.
     */
    @RestController
    @RequestMapping(EndpointConstants.SASS_ENDPOINT)
    public class SassAuthorizationEndpoint extends HttpServlet {
        @Autowired
        SassOrdersService sassOrdersService;
        @Autowired
        SassUserService sassUserService;
        @Autowired
        PositionTableRepository positionTableRepository;
        @Autowired
        WebsitePermissionsRepository websitePermissionsRepository;

        @RequestMapping(value = "/login",method = RequestMethod.POST,
                produces = MediaType.APPLICATION_JSON_VALUE)
        public IDMResponse login(@RequestBody SassCustomer credentials) throws Exception {
            SassCustomer sassCustomer=sassOrdersService.getCustomerObj(credentials) ;
            String accessToken="12345";
            if (StringUtils.isBlank(credentials.getEmail()) ||StringUtils.isBlank(credentials.getLoginName()) || StringUtils.isBlank(credentials.getLoginPassword())) {
                return new IDMResponse(HttpStatus.OK.value(), "Invalid User");
            }
            return new IDMResponse(HttpStatus.OK.value(), "success",sassCustomer);
        }

//        @RequestMapping(value = "/logout")
//        public String logout(@CookieValue("accessToken") String accessToken) throws Exception {
//            if (!StringUtils.isBlank(accessToken)) {
//            hiposService.deleteToken(accessToken);
//            }
//            JSONObject myObject = new JSONObject();
//            myObject.put("message", "success");
//            return myObject.toString();
//        }
        @RequestMapping(value = "/saveLoginDetails", method = RequestMethod.POST,consumes = "application/json", produces = "application/json")
        public SassUser saveLoginDetails(@RequestBody SassUserPojo sassUserPojo)  {
            return sassUserService.saveUserDetails(sassUserPojo);
        }
        @RequestMapping(value = "/userValidate", method = RequestMethod.POST,consumes = "application/json", produces = "application/json")
        public SassUserPojo userValidate(@RequestBody SassUserPojo sassUserPojo)  {
            return sassUserService.userValidate(sassUserPojo);
        }

        @RequestMapping(value = "/pktUserValidate", method = RequestMethod.POST,consumes = "application/json", produces = "application/json")
        public PktUser pktUserValidate(@RequestBody PktUserPojo pktUserPojo)  {
            return sassUserService.pktUserValidate(pktUserPojo);
        }
        @RequestMapping(value = "/getUserDetailsList", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
        public IDMResponse getUserDetailsList(){
            List<SassUserPojo> sassUserPojos= sassUserService.sassUserList();
            return new IDMResponse(HttpStatus.OK.value(), " success",sassUserPojos);
        }
        @RequestMapping(value = "/savepermission", method = RequestMethod.POST,consumes = "application/json", produces = "application/json")
        public ResponseEntity savepermission(@RequestBody IdmPermissionPojo idmPermissionPojo)  {
            return ResponseEntity.status( 200 ).body(sassUserService.savepermission(idmPermissionPojo));
        }
        @RequestMapping(value = "/editUserAccountSetUpWithPermission",method = RequestMethod.POST)
        public ResponseEntity editUserAccountSetUpWithPermission(@RequestParam(value = "id")Long id){
            return ResponseEntity.status( 200).body( sassUserService.editUserAccountSetUpWithPermission(id));
        }
        @RequestMapping(value = "/saveeditDetails", method = RequestMethod.POST,consumes = "application/json", produces = "application/json")
        public SassUser saveeditDetails(@RequestBody SassUserPojo sassUserPojo)  {
            return sassUserService.saveeditUserDetails(sassUserPojo);
        }

        @RequestMapping(value = "/getLoggedInByUser",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity getLoggedInUser(@RequestAttribute String email){
            SassUserPojo sassUserPojo = sassUserService.getLoggedInByUser(email);
            return ResponseEntity.status( 200).body( sassUserPojo);
        }
        @RequestMapping(value = "/getAllPermission",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity getAllPermission(@RequestAttribute String email){
                IdmPermissionPojo idmPermissionPojo = sassUserService.getAllPermission(email);
            return  ResponseEntity.status( 200).body(idmPermissionPojo);
        }




        @RequestMapping(value = "/saveAppPostions", method = RequestMethod.POST,consumes = "application/json", produces = "text/plain")
        public String saveAppPostions(@RequestBody String appPostions)  {

            Gson gson = new Gson();
            Type applicationPostions = new com.google.gson.reflect.TypeToken<List<PositionTable>>() {
            }.getType();
            List<PositionTable> positionTable = gson.fromJson(appPostions, applicationPostions);
            for(PositionTable pos:positionTable){
                sassUserService.saveAppPos(pos);
            }
            return "success";
        }

        @RequestMapping(value = "/getAppPostions", method = RequestMethod.GET, produces = "application/json")
        public ResponseEntity getAppPostions()  {
            List<PositionTable> positionTable =positionTableRepository.findAll();
           return  ResponseEntity.status( 200).body(positionTable);
       }
        @RequestMapping(value = "/getWebsitePermissions", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
        public IDMResponse getWebsitePermissions()   {
            List<WebsitePermissions> websitePermissions = websitePermissionsRepository.findAll();
            return new IDMResponse(HttpStatus.OK.value(), "success", websitePermissions);
        }

        @RequestMapping(value = "/getCoordinates", method = RequestMethod.POST)
        public IDMResponse getCoordinates(@RequestParam(value = "latitude") String latitude,
                                          @RequestParam(value = "longitude") String longitude)   {
            String values = "latitude"+latitude+":"+"longitude"+longitude;
            System.out.println("latitude"+latitude+":"+"longitude"+longitude);
            return new IDMResponse(HttpStatus.OK.value(), "success",values);
        }








    }
