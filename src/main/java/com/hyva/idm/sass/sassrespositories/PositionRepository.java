package com.hyva.idm.sass.sassrespositories;

import com.hyva.idm.sass.sassentities.Operator;
import com.hyva.idm.sass.sassentities.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {
    Position findByName(String name);
    List<Position> findAllByStatus(String status);


 }
