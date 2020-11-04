package com.hyva.idm.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by tnataraj on 1/6/18.
 */
@Entity
@Data
public class UserEntity extends BaseEntity<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userName;
    private String email;
    private String password;
    private boolean active;
    @ManyToOne
    private CompanyEntity companyId;
    @OneToMany(cascade=CascadeType.ALL)
    Set<ModuleEntity> moduleEntitySet;


}
