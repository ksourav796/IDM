package com.hyva.idm.urbanPiper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hyva.idm.HomeController;
import com.hyva.idm.sass.sassendpoints.HiConnectEndPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/urbanPiper")
public class UrbanController {
    @Autowired
    UrbanService urbanPiperService;
    @Autowired
    HiConnectEndPoint hiConnectEndPoint;
    @Autowired
    HomeController homeController;
    @RequestMapping(value = "/v3/posOrders", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity posOrders(@RequestBody String jsonString) throws Exception {
        String data=urbanPiperService.urbanNotification(jsonString);
        final ObjectMapper mapper = new ObjectMapper();
        final JsonNode object = mapper.readTree(data);
        hiConnectEndPoint.getZomatoData(data,object.get("channel").asText(),jsonString);
        return  ResponseEntity.status(200).body("");
    }
    @RequestMapping(value = "/v3/posOrdersStatusChange", method = RequestMethod.POST)
    public ResponseEntity posOrdersStatusChange(@RequestBody String jsonString) throws Exception {
        String data=urbanPiperService.posOrdersStatusChange(jsonString);
        return ResponseEntity.status(200).body(data);
    }
    @RequestMapping(value = "/v3/posRiderStatusChange", method = RequestMethod.POST)
    public ResponseEntity posRiderStatusChange(@RequestBody String jsonString) throws Exception {
        String data=urbanPiperService.posRiderStatusChange(jsonString);
        return  ResponseEntity.status(200).body(data);
    }
}
