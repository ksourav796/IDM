
package com.hyva.idm.sass.sassentities;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
public class PermissionGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long pgId;
    private String featureName; //Sales
    @Column(name = "description", columnDefinition = "LONGTEXT")
    private String description;
    private String saasStatus;
    private String pgkey;

    public PermissionGroup(Long pgId){
        this.pgId=pgId;
    }

public PermissionGroup(){

}
}
