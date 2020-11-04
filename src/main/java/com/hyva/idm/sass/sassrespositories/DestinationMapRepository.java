package com.hyva.idm.sass.sassrespositories;

import com.hyva.idm.sass.sassentities.DestinationMap;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DestinationMapRepository extends CrudRepository<DestinationMap,Long>{
    List<DestinationMap>findByDestinationmap(String map);
   // List<DestinationMap> findBysourceName(String description);
    DestinationMap findBysourceName(String description);
}
