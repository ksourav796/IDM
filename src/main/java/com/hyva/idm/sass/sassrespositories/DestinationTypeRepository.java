package com.hyva.idm.sass.sassrespositories;

import com.hyva.idm.sass.sassentities.DestinationType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DestinationTypeRepository extends CrudRepository<DestinationType,Long> {
    List<DestinationType> findByDocType(String sourceType);

}
