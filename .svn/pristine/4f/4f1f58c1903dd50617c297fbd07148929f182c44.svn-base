package com.hyva.idm.sass.sassmapper;

import com.hyva.idm.sass.sassentities.SaasState;

import com.hyva.idm.sass.sassentities.SassCountry;
import com.hyva.idm.sass.sasspojo.SaasStatePojo;
import com.hyva.idm.sass.sasspojo.SassCountryPojo;

public class SaasStateMapper {

    public static SaasState mapPojoToEntity(SaasStatePojo saveStateDetails){
        SaasState state= new SaasState();
        state.setId(saveStateDetails.getId());
        state.setStateCode(saveStateDetails.getStateCode());
        state.setStateName(saveStateDetails.getStateName());
        state.setVehicleSeries(saveStateDetails.getVehicleSeries());
        state.setStatus(saveStateDetails.getStatus());

        return state;
    }

}
