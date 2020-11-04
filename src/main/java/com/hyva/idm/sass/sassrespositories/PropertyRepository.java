package com.hyva.idm.sass.sassrespositories;

import com.hyva.idm.sass.sassentities.Action;
import com.hyva.idm.sass.sassentities.Property;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {

 List<Property> findAllByName(String name);


 }
