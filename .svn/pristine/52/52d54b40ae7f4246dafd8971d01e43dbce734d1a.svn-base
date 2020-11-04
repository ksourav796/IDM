package com.hyva.idm.urbanPiper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.Gson;
import com.hyva.idm.sass.sassentities.CustomerNotifications;
import com.hyva.idm.sass.sassrespositories.SassCustomerNotificationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UrbanService {
    @Autowired
    SassCustomerNotificationsRepository sassCustomerNotificationsRepository;
   public String urbanNotification(String jsonString)throws Exception{
       final ObjectMapper mapper = new ObjectMapper();
       final JsonNode object = mapper.readTree(jsonString);
       final JsonNode customer = mapper.readTree(object.get("customer").toString());
       final JsonNode order = mapper.readTree(object.get("order").toString());
       final JsonNode details = mapper.readTree(order.get("details").toString());
       final JsonNode charges = mapper.readTree(details.get("charges").toString());
       final JsonNode store = mapper.readTree(order.get("store").toString());
       final JsonNode payment = mapper.readTree(order.get("payment").toString());
       final JsonNode items = mapper.readTree(order.get("items").toString());
       final JsonNode address = mapper.readTree(customer.get("address").toString());
       final JsonNode ext_platforms = mapper.readTree(details.get("ext_platforms").toString());
       ObjectNode customerNode = mapper.createObjectNode();
       ObjectNode objectNode = mapper.createObjectNode();
       ObjectNode resultNode = mapper.createObjectNode();
       customerNode.put("name", customer.get("name").asText());
       customerNode.put("phone_number", customer.get("phone").asText());
       customerNode.put("email", customer.get("email").asText());
       customerNode.put("address\n", address.get("line_1").asText());
       customerNode.put("address_instructions", address.get("landmark").asText());
       customerNode.put("city", address.get("city").asText());
       customerNode.put("delivery_area_latitude", address.get("latitude").asText());
       customerNode.put("delivery_area_longitude", address.get("longitude").asText());
       customerNode.put("delivery_coordinates_type", address.get("tag").asText());
       customerNode.put("delivery_area", address.get("sub_locality").asText());
       customerNode.put("pincode", address.get("pin").asText());
       objectNode.putPOJO("customer_details",customerNode);
       objectNode.putPOJO("createdTime",details.get("created"));
       objectNode.putPOJO("deliveryTime",details.get("delivery_datetime"));
       objectNode.putPOJO("amount_paid",payment.get(0).get("amount"));
       objectNode.putPOJO("order_subtotal",details.get("order_subtotal"));
       objectNode.putPOJO("gross_amount",details.get("order_total"));
       objectNode.putPOJO("net_amount",details.get("order_total"));
       objectNode.putPOJO("order_date_time",details.get("delivery_datetime"));
       objectNode.putPOJO("order_id",details.get("id"));
       objectNode.putPOJO("aggregatorId",ext_platforms.get(0).get("id"));
       objectNode.putPOJO("ext_platforms",ext_platforms);
       objectNode.putPOJO("charges",charges);
       objectNode.putPOJO("payment",payment);
       objectNode.putPOJO("taxes",details.get("taxes"));
       objectNode.putPOJO("order_instructions",order.get("instructions"));
       objectNode.putPOJO("order_type",details.get("order_type"));
       objectNode.putPOJO("order_status",details.get("order_state"));
       objectNode.putPOJO("state",details.get("state"));
       objectNode.putPOJO("payment_mode",payment.get(0).get("option"));
       objectNode.putPOJO("restaurant_id",store.get("merchant_ref_id"));
       objectNode.putPOJO("restaurant_name",store.get("name"));
       objectNode.putPOJO("restaurant_address",store.get("address"));
       objectNode.putPOJO("total_merchant",details.get("order_total"));
       objectNode.putPOJO("coupon",details.get("coupon"));
       objectNode.putPOJO("channel",details.get("channel"));
       objectNode.putPOJO("discount",details.get("discount"));
       objectNode.putPOJO("total_merchant",details.get("order_total"));
       objectNode.putPOJO("total_charges",details.get("total_charges"));
       objectNode.putPOJO("instructions",details.get("instructions"));
       objectNode.putPOJO("total_taxes",details.get("total_taxes"));
       objectNode.putPOJO("order_level_total_charges",details.get("order_level_total_charges"));
       objectNode.putPOJO("order_level_total_taxes",details.get("order_level_total_taxes"));
       objectNode.putPOJO("item_level_total_charges",details.get("item_level_total_charges"));
       objectNode.putPOJO("item_level_total_taxes",details.get("item_level_total_taxes"));
       List<UrbanItemPojo> list=new ArrayList<>();
       for(JsonNode item:items){
           UrbanItemPojo urbanItemPojo=new UrbanItemPojo();
           urbanItemPojo.setItem_name(item.get("title").asText());
           urbanItemPojo.setItem_quantity(item.get("quantity").asLong());
           urbanItemPojo.setItem_final_price(item.get("total_with_tax").asDouble());
           urbanItemPojo.setItem_unit_price(item.get("price").asDouble());
           urbanItemPojo.setFoodType(item.get("food_type").toString());
           urbanItemPojo.setTaxes(item.get("taxes").toString());
           urbanItemPojo.setImgUrl(item.get("image_url").toString());
           urbanItemPojo.setCharges(item.get("charges").toString());
           urbanItemPojo.setDiscount(item.get("discount").asDouble());
           list.add(urbanItemPojo);
       }
       Gson g=new Gson();
       objectNode.putPOJO("order_items",g.toJson(list));
       resultNode.putPOJO("channel",details.get("channel"));
       resultNode.putPOJO("order",objectNode);
       String jsonCompleteData = resultNode.toString();
       return jsonCompleteData;
   }
   public String posOrdersStatusChange(String jsonString)throws Exception{
       final ObjectMapper mapper = new ObjectMapper();
       final JsonNode object = mapper.readTree(jsonString);
       final JsonNode orderId = mapper.readTree(object.get("order_id").toString());
       CustomerNotifications customerNotifications=sassCustomerNotificationsRepository.findAllByCustomerNotification(orderId.toString());
       if(customerNotifications!=null) {
           customerNotifications.setStatusChangeData(jsonString);
           customerNotifications.setStatus(object.get("new_state").textValue());
           sassCustomerNotificationsRepository.save(customerNotifications);
       }
       return "sucess";
   }
    public String posRiderStatusChange(String jsonString)throws Exception{
        final ObjectMapper mapper = new ObjectMapper();
        final JsonNode object = mapper.readTree(jsonString);
        final JsonNode additionalinfo = mapper.readTree(object.get("additional_info").toString());
        final JsonNode delivery_info = mapper.readTree(object.get("delivery_info").toString());
        final JsonNode status = mapper.readTree(delivery_info.get("current_state").toString());
        final JsonNode external_channel = mapper.readTree(additionalinfo.get("external_channel").toString());
        final JsonNode orderId = mapper.readTree(external_channel.get("order_id").toString());
        CustomerNotifications customerNotifications=sassCustomerNotificationsRepository.findAllByCustomerNotification(orderId.toString());
        if(customerNotifications!=null) {
            customerNotifications.setRiderChangeData(jsonString);
            customerNotifications.setStatus(status.toString());
            sassCustomerNotificationsRepository.save(customerNotifications);
        }
        return "sucess";
    }
}
