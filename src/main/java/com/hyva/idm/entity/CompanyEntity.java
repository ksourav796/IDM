package com.hyva.idm.entity;

import lombok.Data;
import javax.persistence.*;

/**
 * Created by tnataraj on 1/15/18.
 */
@Entity
@Data
public class CompanyEntity extends BaseEntity<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String companyName;
    @Column(unique = true)
    private String emailId;
    @Column(unique = true)
    private String keyWord;
    private String companyType;
    @Column(unique = true)
    private String saasToken;
    private boolean active;

}
