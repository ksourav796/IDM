package com.hyva.idm.sass.sassentities;

import com.hyva.idm.entity.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class DestinationType  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private String destinationName;
    private String docType;
    private String description;
    private String status;

}
