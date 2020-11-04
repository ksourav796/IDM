package com.hyva.idm.sass.sassentities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
public class PositionTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private String form_id;
    @Column(nullable = false)
    private String drag_id;
    private String position;
    @Column(name = "left_px")
    private String left;
    private String top;
    private String height;
    private String width;
    private String masterName;
    private String applicationId;


}
