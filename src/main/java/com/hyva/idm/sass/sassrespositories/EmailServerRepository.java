package com.hyva.idm.sass.sassrespositories;

import com.hyva.idm.sass.sassentities.EmailServer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EmailServerRepository extends JpaRepository<EmailServer,Long> {
    EmailServer findByUserName(String username);
}
