package com.hyva.idm.sass.sassrespositories;

import com.hyva.idm.sass.sassentities.Operator;
import com.hyva.idm.sass.sassentities.Validator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ValidatorRepository extends JpaRepository<Validator, Long> {
    Validator findByName(String name);
    Validator findByNameAndIdNotIn(String name,Long Id);
    List<Validator> findAllByStatus(String Status);


}
