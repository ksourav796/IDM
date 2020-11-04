/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hyva.idm.sass.sassentities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class SassCurrency  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long currencyId;
    private String currencyName;
    private String currencyCode;
    private String currencySymbol;
    @Column(name = "currencyDescription", columnDefinition = "LONGTEXT")
    private String currencyDescription;
    private String currencySymbolPlace;
    private String AccountCode;
    private String locationId;
    private String useraccount_id;
    private String status;
    @OneToOne
    private SassCountry SassCountryId;

    public SassCurrency(Long currencyId) {
        this.currencyId=currencyId;
    }

    public SassCurrency() {
    }

    public SassCurrency(String currencyCode, String currencyDescription, String currencyName, String currencySymbol, String currencySymbolPlace) {
        this.currencyName = currencyName;
        this.currencyCode = currencyCode;
        this.currencySymbol = currencySymbol;
        this.currencyDescription = currencyDescription;
        this.currencySymbolPlace = currencySymbolPlace;
    }
    }
