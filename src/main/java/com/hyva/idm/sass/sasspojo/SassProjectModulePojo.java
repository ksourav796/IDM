package com.hyva.idm.sass.sasspojo;


import lombok.Data;

@Data
public class SassProjectModulePojo {
    private Long id;
    private String projectname;
    private String description;
    private String status;
    private String permissions;
    public SassProjectModulePojo() {
    }
    public SassProjectModulePojo(Long id, String projectname, String description, String status, String permissions) {
        this.id=id;
        this.projectname=projectname;
        this.description=description;
        this.status=status;
        this.permissions=permissions;
    }
}
