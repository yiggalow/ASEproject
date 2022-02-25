package de.dhbw.ase.mangacollector.repository;

import de.dhbw.ase.mangacollector.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface EpisodeRepository extends JpaRepository<Episode, Integer> {
    // intentionally left blank, see JpaRepository interface definition

    /** CREATE **/

    /** READ **/

    /** UPDATE **/

    /** DELETE **/

}

