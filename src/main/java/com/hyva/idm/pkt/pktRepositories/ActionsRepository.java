package com.hyva.idm.pkt.pktRepositories;

import com.hyva.idm.pkt.pktRelations.Actions;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * krishna
 */
public interface ActionsRepository extends JpaRepository<Actions,Long> {
    Actions findByName(String name);
    List<Actions> findAllByStatus(String status);
    Actions findByNameAndIdNotIn(String name, Long Id);
    List<Actions> findAllByNameContaining(String typeName, Pageable pageable);
    List<Actions> findAllByNameContaining(String typeName);
    Actions findFirstByNameContaining(String typeName, Sort sort);
    Actions findFirstBy(Sort sort);
    List<Actions> findAllBy(Pageable pageable);
}
