package de.dhbw.ase.plugins.persistence.hibernate.country;
import de.dhbw.ase.mangacollector.domain.country.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface SpringDataCountryRepository extends JpaRepository<Country, Integer> {
    // intentionally left blank, see JpaRepository interface definition

    /** CREATE **/

    /** READ **/

    /** UPDATE **/

    /** DELETE **/

}

