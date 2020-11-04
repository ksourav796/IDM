package com.hyva.idm.sass.sasspojo;

import lombok.Data;

import javax.persistence.Column;
import javax.xml.soap.Text;

@Data
public class PropertyPojo {
    private Long id;
    private String file;
    @Column(columnDefinition = "Text")
    private String description;
//    private String status;
    private String name;
    private String developerId;
}
