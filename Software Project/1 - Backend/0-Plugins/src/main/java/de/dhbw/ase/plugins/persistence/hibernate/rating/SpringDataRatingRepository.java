package de.dhbw.ase.plugins.persistence.hibernate.rating;


import de.dhbw.ase.mangacollector.domain.rating.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface SpringDataRatingRepository extends JpaRepository<Rating, Integer> {
    // intentionally left blank, see JpaRepository interface definition

    /** CREATE **/

    /** READ **/

    /** UPDATE **/

    /** DELETE **/

}

