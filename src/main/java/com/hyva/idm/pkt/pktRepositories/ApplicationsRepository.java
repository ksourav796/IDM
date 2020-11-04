package com.hyva.idm.pkt.pktRepositories;

import com.hyva.idm.pkt.pktRelations.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * krishna
 */
public interface ApplicationsRepository extends JpaRepository<Application,Long> {
    Application findByName(String name);
    List<Application> findAllByStatus(String status);
    List<Application>findAllByName(String name);
    List<Application> findByDeveloperId(String id);
}
