package com.hyva.idm.sass.sassentities;

import com.hyva.idm.entity.BaseEntity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Data
public class SaasState extends BaseEntity<String> {
@Id
@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
@GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private String stateCode;
    private String stateName;
    private String vehicleSeries;
    private String Status;
    @OneToOne
    private SassCountry countryId;

    public SaasState(Long id) {
        this.id=id;
    }

    public SaasState(String stateCode, String vehicleSeries, String status, String stateName, SassCountry countryId) {
        this.stateCode = stateCode;
        this.stateName = stateName;
        this.vehicleSeries = vehicleSeries;
        this.Status=status;
        this.countryId = countryId;
    }

    public SaasState() {
    }




}
