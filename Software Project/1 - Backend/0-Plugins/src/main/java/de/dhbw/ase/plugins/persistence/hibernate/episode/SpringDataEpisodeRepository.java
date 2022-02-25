package de.dhbw.ase.plugins.persistence.hibernate.episode;

import de.dhbw.ase.mangacollector.domain.episode.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface SpringDataEpisodeRepository extends JpaRepository<Episode, Integer> {
    // intentionally left blank, see JpaRepository interface definition

    /** CREATE **/

    /** READ **/

    /** UPDATE **/

    /** DELETE **/

}

