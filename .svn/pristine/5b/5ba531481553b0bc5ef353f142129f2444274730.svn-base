package com.hyva.idm.pkt.pktRepositories;

import com.hyva.idm.pkt.pktRelations.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * krishna
 */
@Repository
public interface PositionsRepository extends JpaRepository<Position,Long> {
    Position findByName(String name);
    List<Position> findAllByStatus(String status);
}
