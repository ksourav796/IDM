package com.hyva.idm.sass.sassrespositories;

import com.hyva.idm.sass.sassentities.Operator;
import com.hyva.idm.sass.sassentities.PktFields;
import com.hyva.idm.sass.sasspojo.Operatorpojo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface OperatorRepository extends JpaRepository<Operator, Long> {
    Operator findByName(String name);
    Operator findByNameAndIdNotIn(String name,Long Id);
    List<Operator> findAllByStatus(String Status);
    List<Operator> findAllByNameContaining(String typeName, Pageable pageable);
    List<Operator> findAllByNameContaining(String typeName);
    Operator findFirstByNameContaining(String typeName, Sort sort);
    Operator findFirstBy(Sort sort);
    List<Operator> findAllBy(Pageable pageable);
    Operator findAllByName(String name);

 }
