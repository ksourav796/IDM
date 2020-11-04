package com.hyva.idm.sass.sasspojo;

import com.hyva.idm.pkt.pktBeans.PktPermissionBean;
import java.util.List;

public class PositionsPermissionPojo {

    public List<PktPermissionBean> getPostionsPermissions() {
        return postionsPermissions;
    }

    public void setPostionsPermissions(List<PktPermissionBean> postionsPermissions) {
        this.postionsPermissions = postionsPermissions;
    }

    private List<PktPermissionBean> postionsPermissions;

}
