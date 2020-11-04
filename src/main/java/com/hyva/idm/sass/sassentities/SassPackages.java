package com.hyva.idm.sass.sassentities;

import com.hyva.idm.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class SassPackages extends BaseEntity<String> {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long packagesSASSId;

  private String packageName;
  private String redirectUrl;
  private String syncUrl;
  private String licncUrl;
  private String status;
  private String companyCreateurl;
}
