package com.hyva.idm.pkt.pktRelations;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * krishna
 */
@Entity
@Data
public class ColumnTypes {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "Id",nullable = true)
    private Long Id;
    private String name;
    private String Description;
    private String status;

}
