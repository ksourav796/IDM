package com.hyva.idm.sass.sassentities;

import lombok.Data;
import org.aspectj.weaver.ast.Not;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 *
 */

@Entity
@Data
public class ColumnType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "Id",nullable = true)
    private Long Id;
    private String name;
    private String Description;
    private String status;

}
