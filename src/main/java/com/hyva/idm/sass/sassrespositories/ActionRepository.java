package com.hyva.idm.sass.sassrespositories;

import com.hyva.idm.sass.sassentities.Action;
import com.hyva.idm.sass.sassentities.Operator;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActionRepository extends JpaRepository<Action, Long> {
    Action findByName(String name);
    List<Action> findAllByStatus(String status);
    Action findByNameAndIdNotIn(String name,Long Id);
    List<Action> findAllByNameContaining(String typeName, Pageable pageable);
    List<Action> findAllByNameContaining(String typeName);
    Action findFirstByNameContaining(String typeName, Sort sort);
    Action findFirstBy(Sort sort);
    List<Action> findAllBy(Pageable pageable);
 }
