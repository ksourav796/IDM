package com.hyva.idm.sass.sassrespositories;

import com.hyva.idm.sass.sassentities.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketsRepository extends JpaRepository<Tickets,Long> {
    Tickets findByNameAndIdNotIn(String name,Long id);
    Tickets findByName(String name);

}
