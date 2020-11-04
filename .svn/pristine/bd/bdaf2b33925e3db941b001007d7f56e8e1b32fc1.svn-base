package com.hyva.idm.hipro.hiproendpoint;

import com.hyva.idm.hipro.hiproentity.Subform;
import com.hyva.idm.hipro.hiprorepository.SubformRepository;
import com.hyva.idm.sass.sassentities.SassCustomer;
import com.hyva.idm.sass.sassentities.Application;

import com.hyva.idm.hipro.hiproentity.HiproDump;
import com.hyva.idm.hipro.hiprorepository.HiproRepository;
import com.hyva.idm.pojo.IDMResponse;
import com.hyva.idm.sass.sassrespositories.ApplicationRepository;
import com.hyva.idm.sass.sassrespositories.SassCustomerRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/hipro")
public class HiproEndpoint {
    @Autowired
    HiproRepository hiproRepository;
    @Autowired
    SassCustomerRepository sassCustomerRepository;
    @Autowired
    ApplicationRepository applicationRepository;
    @Autowired
    SubformRepository subformRepository;


    @RequestMapping(value = "/savehipro", method = RequestMethod.POST, consumes = "application/json",
            produces = "application/json")
    public IDMResponse savehipro(@RequestBody String jsonString) throws Exception {
        JSONObject jsonObj = new JSONObject(jsonString);
        HiproDump sql = new HiproDump();
        sql.setAppKey(jsonObj.get("app_key").toString());
        sql.setJsonData(jsonObj.get("jsondata").toString());
        sql.setAppName(jsonObj.get("app_id").toString());
        sql.setDeveloperId(jsonObj.get("developerId").toString());
        hiproRepository.save(sql);
        return new IDMResponse(HttpStatus.OK.value(), " success");
    }

    @RequestMapping(value = "/gethipro", method = RequestMethod.POST, consumes = "application/json")
    public List gethipro(@RequestBody String jsonString) throws IOException, JSONException {
        JSONObject jsonObj = new JSONObject(jsonString);
        List<HiproDump> dump = (List<HiproDump>) hiproRepository.findByAppNameAndDeveloperId(jsonObj.get("app_Name").toString(),jsonObj.get("developerId").toString());
//        HashMap node1 = new HashMap();
//        List<String> jsonList = new ArrayList<>();
//        ArrayList arrayList = new ArrayList();
//        for(HiproDump hiproDump:dump){
//            String jsonLists =  hiproDump.getJsonData();
//            node1.put("appkey",hiproDump.getAppKey());
//            node1.put("jsonData",jsonLists);
//            arrayList.add(node1);
//            System.out.println(jsonList);
//
//        }

        return  dump;

    }

    @RequestMapping(value = "/savecustomer", method = RequestMethod.POST, consumes = "application/json",
            produces = "application/json")
    public IDMResponse savecustomer(@RequestBody String jsonString) throws Exception {
        JSONObject jsonObj = new JSONObject(jsonString);
        SassCustomer sql = new SassCustomer();
        sql.setCustomerName(jsonObj.get("customername").toString());
        sql.setEmail(jsonObj.get("email").toString());
//        sql.setAddress(jsonObj.get("address").toString());
        sql.setContactPerson(jsonObj.get("customercontact").toString());
        sql.setLoginName(jsonObj.get("username").toString());
        sql.setLoginPassword(jsonObj.get("password").toString());

        sassCustomerRepository.save(sql);
        return new IDMResponse(HttpStatus.OK.value(), " success");
    }

    @RequestMapping(value = "/getcustomer", method = RequestMethod.POST, consumes = "application/json")
    public SassCustomer getcustomer(@RequestBody String jsonString) throws IOException, JSONException {
        JSONObject jsonObj = new JSONObject(jsonString);
        SassCustomer customer = sassCustomerRepository.findByEmailAndLoginNameAndLoginPassword(jsonObj.get("email").toString(), jsonObj.get("username").toString(), jsonObj.get("password").toString());
        return customer;
    }

    @RequestMapping(value = "/getapplication", method = RequestMethod.POST, consumes = "application/json")
    public List getapplication(@RequestBody String jsonString) throws IOException, JSONException {
        JSONObject jsonObj = new JSONObject(jsonString);
        List<Application> app = (List<Application>) applicationRepository.findAll();
        return app;
    }

    @RequestMapping(value = "/savesubform", method = RequestMethod.POST, consumes = "application/json",
            produces = "application/json")
    public IDMResponse savesubform(@RequestBody String jsonString) throws Exception {
        JSONObject jsonObj = new JSONObject(jsonString);
        Subform subform = new Subform();
        subform.setAppKey(jsonObj.get("app_key").toString());
        subform.setJsonData(jsonObj.get("jsondata").toString());
        subform.setAppName(jsonObj.get("app_id").toString());
        subform.setDeveloperId(jsonObj.get("developerId").toString());
        subformRepository.save(subform);
        return new IDMResponse(HttpStatus.OK.value(), " success");
    }

    @RequestMapping(value = "/getsubform", method = RequestMethod.POST, consumes = "application/json")
    public List getsubform(@RequestBody String jsonString) throws IOException, JSONException {
        JSONObject jsonObj = new JSONObject(jsonString);
        String appName = jsonObj.get("appName").toString();
        String appkey = jsonObj.get("app_key").toString();
        String developerId = jsonObj.get("developerId").toString();
        List<Subform> app = (List<Subform>) subformRepository.findAllByAppNameAndAppKeyAndDeveloperId(appName, appkey,developerId);
        ArrayList list = new ArrayList();
        for (Subform list1 : app) {
            list.add(list1.getJsonData());
        }
        return list;
    }
    @RequestMapping(value = "/updatehipro", method = RequestMethod.POST, consumes = "application/json")
    public IDMResponse updatehipro(@RequestBody String jsonString) throws IOException, JSONException {
        JSONObject jsonObj = new JSONObject(jsonString);
        HiproDump dump = hiproRepository.findByAppKeyAndDeveloperId(jsonObj.get("app_key").toString(),jsonObj.get("developerId").toString());
        if (dump != null) {

//            dump.setAppKey(jsonObj.get("app_key").toString());
//            dump.setAppName(jsonObj.get("app_Name").toString());
            dump.setJsonData(jsonObj.get("jsondata").toString());
//            dump.setDeveloperId(jsonObj.get("developerId").toString());
//            dump.setAppKey(jsonObj.get("app_key").toString());
            hiproRepository.save(dump);

            return new IDMResponse(HttpStatus.OK.value(), " success");
        } else {
            return null;
        }
    }
    @RequestMapping(value = "/updatesubform", method = RequestMethod.POST, consumes = "application/json")
    public IDMResponse updatesubform(@RequestBody String jsonString) throws IOException, JSONException {
        JSONObject jsonObj = new JSONObject(jsonString);
        Subform form = subformRepository.findByAppKeyAndDeveloperId(jsonObj.get("app_key").toString(),jsonObj.get("developerId").toString());
        if (form != null) {

//            form.setAppKey(jsonObj.get("app_key").toString());
//            form.setAppName(jsonObj.get("app_Name").toString());
            form.setJsonData(jsonObj.get("jsondata").toString());
//            form.setDeveloperId(jsonObj.get("developerId").toString());
            subformRepository.save(form);

            return new IDMResponse(HttpStatus.OK.value(), " success");
        } else {
            return null;
        }
    }

}
