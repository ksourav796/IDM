package com.hyva.idm.sass.sassentities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by sahera on 10/27/2017.
 */
@Entity
@Data
public class SassProjectModule implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private String projectname;
    @Column(name = "description", columnDefinition = "LONGTEXT")
    private String description;
    private String status;
    @Column(name = "permissions", columnDefinition = "LONGTEXT")
    private String permissions;


    public SassProjectModule() {

    }

    public SassProjectModule(String projectname, String description, String status) {
        this.projectname = projectname;
        this.description = description;
        this.status = status;
    }
}
