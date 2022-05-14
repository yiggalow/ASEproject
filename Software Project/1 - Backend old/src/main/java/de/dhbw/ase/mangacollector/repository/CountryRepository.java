package de.dhbw.ase.mangacollector.repository;
import de.dhbw.ase.mangacollector.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface CountryRepository extends JpaRepository<Country, Integer> {
    // intentionally left blank, see JpaRepository interface definition

    /** CREATE **/

    /** READ **/

    /** UPDATE **/

    /** DELETE **/

}

