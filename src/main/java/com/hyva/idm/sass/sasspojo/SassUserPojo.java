package com.hyva.idm.sass.sasspojo;

import lombok.Data;

@Data
public class SassUserPojo {
    private int useraccount_id;
    private String userName;
    private String phone;
    private String passwordUser;
    private String full_name;
    private String email;
    private String securityQuestion;
    private String securityAnswer;
    private String status;
    private String userStatus;
    private String subscriptionFor;
    private String developerId;
    private String customer;
    private String validityStatus;
    private String application;


    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
}
