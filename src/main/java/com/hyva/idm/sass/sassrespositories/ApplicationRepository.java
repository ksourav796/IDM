package com.hyva.idm.sass.sassrespositories;

import com.hyva.idm.sass.sassentities.Action;
import com.hyva.idm.sass.sassentities.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    Application findByName(String name);
    Application findByNameAndIdNot(String name,Long id);
    List<Application> findAllByStatus(String status);
List<Application>findAllByName(String name);
List<Application> findByDeveloperId(String id);
 }
