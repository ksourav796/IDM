package com.hyva.idm.pkt.pktRelations;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * krishna
 */
@Entity
@Data
@Table(name = "PktBuilder")
public class PktBuilder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long pktBuilderId;
    @Column(name = "Application_Name")
    private String applicationName;
    @Column(name="FooterValue",columnDefinition = "LONGTEXT")
    private String footerValue;
    @Column(name = "HeaderValue",columnDefinition = "LONGTEXT")
    private String headerValue;
    @Column(name = "builderValue",columnDefinition = "LONGTEXT")
    private String builderValue;
    @Column(name="status")
    private String status;
    private boolean pageRequired;


    public Long getPktBuilderId() {
        return pktBuilderId;
    }

    public void setPktBuilderId(Long pktBuilderId) {
        this.pktBuilderId = pktBuilderId;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getFooterValue() {
        return footerValue;
    }

    public void setFooterValue(String footerValue) {
        this.footerValue = footerValue;
    }

    public String getHeaderValue() {
        return headerValue;
    }

    public void setHeaderValue(String headerValue) {
        this.headerValue = headerValue;
    }

    public String getBuilderValue() {
        return builderValue;
    }

    public void setBuilderValue(String builderValue) {
        this.builderValue = builderValue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isPageRequired() {
        return pageRequired;
    }

    public void setPageRequired(boolean pageRequired) {
        this.pageRequired = pageRequired;
    }
}
