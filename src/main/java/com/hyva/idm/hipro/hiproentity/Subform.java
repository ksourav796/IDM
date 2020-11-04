package com.hyva.idm.hipro.hiproentity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
public class Subform {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")

    private Long moduleId;
    private String appKey;
    @Column(name="jsonData",columnDefinition = "LONGTEXT")
    private String jsonData;
    private String appName;
    private String developerId;

    public String getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(String developerId) {
        this.developerId = developerId;
    }
}
