package com.hyva.idm.sass.sassentities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private String File;
    @Column(columnDefinition = "Text")
    private String description;
    private String name;
    private String developerId;

}
