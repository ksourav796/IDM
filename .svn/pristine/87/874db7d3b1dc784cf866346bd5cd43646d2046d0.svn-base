package com.hyva.idm.sass.sassmapper;

import com.hyva.idm.sass.sassentities.PositionTable;
import com.hyva.idm.sass.sasspojo.PositionTablePojo;

import java.util.ArrayList;
import java.util.List;

public class PositionTableMapper {
    public  static PositionTable mapPojoToEntity(PositionTablePojo posPojo){
        PositionTable positionTable=new PositionTable();
        positionTable.setId(posPojo.getId());
        positionTable.setForm_id(posPojo.getForm_id());
        positionTable.setDrag_id( posPojo.getDrag_id());
        positionTable.setPosition( posPojo.getPosition() );
        positionTable.setLeft( posPojo.getLeft() );
        positionTable.setTop( posPojo.getTop() );
        positionTable.setHeight(posPojo.getHeight());
        positionTable.setWidth(posPojo.getWidth());
        positionTable.setMasterName(posPojo.getMasterName());
        positionTable.setApplicationId(posPojo.getApplicationId());
        return  positionTable;
    }



    public static List<PositionTablePojo> mapEntityToPojo(List<PositionTable> positionTableList){
        List<PositionTablePojo> positionTablePojos = new ArrayList<>();
        for(PositionTable positionTable:positionTableList){
            PositionTablePojo positionTablePojo = new PositionTablePojo();
            positionTablePojo.setId( positionTable.getId());
            positionTablePojo.setForm_id(positionTable.getForm_id());
            positionTablePojo.setDrag_id( positionTable.getDrag_id());
            positionTablePojo.setPosition( positionTable.getPosition());
            positionTablePojo.setLeft( positionTable.getLeft());
            positionTablePojo.setTop( positionTable.getTop());
            positionTablePojo.setHeight( positionTable.getHeight());
            positionTablePojo.setWidth( positionTable.getWidth());
            positionTablePojo.setMasterName(positionTable.getMasterName());
            positionTablePojo.setApplicationId(positionTable.getApplicationId()  );
            positionTablePojos.add( positionTablePojo);
        }
        return positionTablePojos;
    }
}
