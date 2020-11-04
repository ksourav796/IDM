package com.hyva.idm.sass.sassrespositories;
import com.hyva.idm.sass.sassentities.SassCountry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SassCountryRepository extends CrudRepository<SassCountry, Long> {
    SassCountry findByCountryName(String countryName);
    SassCountry findByCountryId(Long countryId);
}
