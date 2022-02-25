package de.dhbw.ase.mangacollector.repository;

import de.dhbw.ase.mangacollector.model.Manga;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface MangaRepository extends JpaRepository<Manga, Integer> {
    // intentionally left blank, see JpaRepository interface definition

    /** CREATE **/

    /** READ **/

    /** UPDATE **/

    /** DELETE **/

}

