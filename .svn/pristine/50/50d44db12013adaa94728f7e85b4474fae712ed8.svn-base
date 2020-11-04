package com.hyva.idm.sass.sassendpoints;

import com.hyva.idm.constants.EndpointConstants;
import com.hyva.idm.sass.sassconstant.HiConnectConstants;
import com.hyva.idm.sass.sasspojo.ZomatoPojo;
import com.hyva.idm.sass.sassservice.ZomatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import java.nio.file.LinkOption;

@RestController
@RequestMapping(EndpointConstants.ZOMATO_ENDPOINT)
public class ZomatoEndPoint extends HttpServlet {

    @Autowired
    ZomatoService zomatoService;


    @RequestMapping(value = "/changeStatus",method = RequestMethod.POST,produces = "application/json",consumes = "application/json")
    public ResponseEntity changeStatus(@RequestBody ZomatoPojo zomatoPojo) throws Exception{
        return ResponseEntity.status(200).body(zomatoService.changeStatus(zomatoPojo));
    }
    @RequestMapping(value = "/saveasiandelivery",method = RequestMethod.POST,produces = "application/json",consumes = "application/json")
    public ResponseEntity saveasiandelivery(@RequestBody ZomatoPojo zomatoPojo) throws Exception{
        return ResponseEntity.status(200).body(zomatoService.saveasiandelivery(zomatoPojo));
    }
    @RequestMapping(value = "/savepickedup",method = RequestMethod.POST,produces = "application/json",consumes = "application/json")
    public ResponseEntity savepickedup(@RequestBody ZomatoPojo zomatoPojo) throws Exception{
        return ResponseEntity.status(200).body(zomatoService.savepickedup(zomatoPojo));
    }
    @RequestMapping(value = "/savedeliverd",method = RequestMethod.POST,produces = "application/json",consumes = "application/json")
    public ResponseEntity savedeliverd(@RequestBody ZomatoPojo zomatoPojo) throws Exception{
        return ResponseEntity.status(200).body(zomatoService.savedeliverd(zomatoPojo));
    }
    @RequestMapping(value = "/saveready",method = RequestMethod.POST,produces = "application/json",consumes = "application/json")
    public ResponseEntity saveready(@RequestBody ZomatoPojo zomatoPojo) throws Exception{
        return ResponseEntity.status(200).body(zomatoService.saveready(zomatoPojo));
    }

}
