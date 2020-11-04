package com.hyva.idm.sass.sasspojo;

import lombok.Data;

import javax.persistence.Column;
@Data
public class PositionTablePojo {
    private Long id;
    private String form_id;
    private String drag_id;
    private String position;
    private String left;
    private String top;
    private String height;
    private String width;
    private String masterName;
    private String applicationId;
}
