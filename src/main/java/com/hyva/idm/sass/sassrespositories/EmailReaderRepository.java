package com.hyva.idm.sass.sassrespositories;

import com.hyva.idm.sass.sassentities.EmailReader;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmailReaderRepository extends CrudRepository<EmailReader,Long> {
    List<EmailReader>findByEmaillistenerId(Long emaillistenerId);
}
