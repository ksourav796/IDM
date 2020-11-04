package com.hyva.idm.hipro.hiprorepository;

import com.hyva.idm.hipro.hiproentity.HiproDump;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HiproRepository extends CrudRepository<HiproDump,Long> {
   List<HiproDump> findByAppNameAndDeveloperId(String appName,String id);
   HiproDump findByAppKeyAndDeveloperId(String appkey,String id);
}
