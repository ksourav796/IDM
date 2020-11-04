package com.hyva.idm.pkt.pktMappers;

import com.hyva.idm.pkt.pktRelations.Position;
import com.hyva.idm.pkt.pktBeans.PositionBean;
import org.springframework.stereotype.Component;

/**
 * krishna
 */
@Component
public class PositionMapper {
    public static Position mapActionPojoToEnity(PositionBean positionPojo){
        Position position  = new Position();
        position.setId(positionPojo.getId());
        position.setName(positionPojo.getName());
        position.setDescription(positionPojo.getDescription());
        position.setStatus(positionPojo.getStatus());
        return  position;
    }
}
