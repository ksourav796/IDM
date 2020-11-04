package com.hyva.idm.pkt.pktRepositories;

import com.hyva.idm.pkt.pktRelations.Validator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * krishna
 */
@Repository
public interface ValidatorsRepository extends JpaRepository<Validator, Long> {
    Validator findByName(String name);

    Validator findByNameAndIdNotIn(String name, Long Id);

    List<Validator> findAllByStatus(String Status);
}
