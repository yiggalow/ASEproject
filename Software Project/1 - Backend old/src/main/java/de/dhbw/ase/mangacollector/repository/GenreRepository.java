package de.dhbw.ase.mangacollector.repository;

import de.dhbw.ase.mangacollector.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface GenreRepository extends JpaRepository<Genre, Integer> {
    // intentionally left blank, see JpaRepository interface definition

    /** CREATE **/

    /** READ **/

    /** UPDATE **/

    /** DELETE **/

}

