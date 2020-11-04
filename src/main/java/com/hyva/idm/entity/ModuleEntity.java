package com.hyva.idm.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by tnataraj on 1/15/18.
 */
@Entity
@Data
public class ModuleEntity extends BaseEntity<String> {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String moduleName;

    private String description;

    @Column(unique = true)
    private String urlPrefix;


}
