package com.hyva.idm.sass.sassrespositories;

import com.hyva.idm.sass.sassentities.PractitionerRegistration;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PractitionerRegistrationRepository extends CrudRepository<PractitionerRegistration, Long> {
    List<PractitionerRegistration> findAllByEmail(String email );
    PractitionerRegistration findByName(String name);
}
