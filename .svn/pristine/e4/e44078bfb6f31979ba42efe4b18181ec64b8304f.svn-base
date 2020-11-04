package com.hyva.idm.sass.sassentities;


import com.hyva.idm.entity.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
public class AddOnn extends BaseEntity<String> {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
  @GenericGenerator(name = "native", strategy = "native")
  private Long adoneId;
  @OneToOne
  private SassSubscriptions subId;
  private String addonName;
  private String addonPrice;
  private String addonPermission;
  private String status;

}
