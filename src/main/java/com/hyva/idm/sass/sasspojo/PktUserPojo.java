package com.hyva.idm.sass.sasspojo;

import lombok.Data;

@Data
public class PktUserPojo {
    private Long id;
    private String userName;
    private String password;
    private String email;
    private String application;
    private String roles;
}
