package de.dhbw.ase.plugins.persistence.hibernate.genre;

import de.dhbw.ase.mangacollector.domain.genre.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface SpringDataGenreRepository extends JpaRepository<Genre, Integer> {
    // intentionally left blank, see JpaRepository interface definition

    /** CREATE **/

    /** READ **/

    /** UPDATE **/

    /** DELETE **/

}

