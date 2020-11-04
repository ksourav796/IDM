package com.hyva.idm.sass.sassentities;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
public class Notifications {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
  @GenericGenerator(name = "native", strategy = "native")
  private Long notificationId;
  private String fromRegno;
  private String toRegno;
  private Long userId;
  private java.sql.Timestamp timestamp;
  private String status;
  private String typeDoc;
  private String toCompname;
  private String toEmail;
  private String contact;
  private String address;
  private String fromCompname;
  @OneToOne
  private TransactionsData transactionId;
  private String fromEmail;
  private String fromContact;
  private String fromAddress;
  private String typeFlag;
  private String totalcheckoutamt;
  private String totaltax;
  private String viewStatus;

}
