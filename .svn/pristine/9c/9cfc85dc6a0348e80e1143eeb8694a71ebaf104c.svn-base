package com.hyva.idm.hipro.hiprorepository;

import com.hyva.idm.hipro.hiproentity.Subform;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubformRepository extends CrudRepository<Subform,Long>{
    List<Subform>findAllByAppNameAndAppKeyAndDeveloperId(String appname,String appkey,String developerId);
    Subform findByAppKeyAndDeveloperId(String appkey,String id);
}
