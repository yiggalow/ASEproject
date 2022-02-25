package de.dhbw.ase.mangacollector.repository;

import de.dhbw.ase.mangacollector.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
    // intentionally left blank, see JpaRepository interface definition

    /** CREATE **/

    /** READ **/

    /** UPDATE **/

    /** DELETE **/

}

