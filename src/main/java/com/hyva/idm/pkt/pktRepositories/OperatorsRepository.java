package com.hyva.idm.pkt.pktRepositories;

import com.hyva.idm.pkt.pktRelations.Operators;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * krishna
 */
@Repository
public interface OperatorsRepository extends JpaRepository<Operators,Long> {
    Operators findByName(String name);
   Operators findByNameAndIdNotIn(String name, Long Id);
    List<Operators> findAllByStatus(String Status);
    List<Operators> findAllByNameContaining(String typeName, Pageable pageable);
    List<Operators> findAllByNameContaining(String typeName);
    Operators findFirstByNameContaining(String typeName, Sort sort);
    Operators findFirstBy(Sort sort);
    List<Operators> findAllBy(Pageable pageable);
    Operators findAllByName(String name);
}
