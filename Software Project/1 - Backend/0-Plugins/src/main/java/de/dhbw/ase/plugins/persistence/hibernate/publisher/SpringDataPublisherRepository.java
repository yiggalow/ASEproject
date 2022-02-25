package de.dhbw.ase.plugins.persistence.hibernate.publisher;


import de.dhbw.ase.mangacollector.domain.publisher.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface SpringDataPublisherRepository extends JpaRepository<Publisher, Integer> {
    // intentionally left blank, see JpaRepository interface definition

    /** CREATE **/

    /** READ **/

    /** UPDATE **/

    /** DELETE **/

}

