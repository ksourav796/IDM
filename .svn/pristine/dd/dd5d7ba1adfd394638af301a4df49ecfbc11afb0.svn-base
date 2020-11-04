package com.hyva.idm.pkt.pktRepositories;

import com.hyva.idm.pkt.pktRelations.PktBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * krishna
 */
@Repository
public interface PktBuilderRepository  extends JpaRepository<PktBuilder,Long>{
    List<PktBuilder> findAllByApplicationName(String name);
    PktBuilder findByApplicationName(String name);
    PktBuilder findByApplicationNameAndPktBuilderId(String name,Long id);
    PktBuilder findByPktBuilderId(Long id);
    List<PktBuilder> findAllByApplicationNameAndPktBuilderIdNotIn(String applicationName,Long id);
}
