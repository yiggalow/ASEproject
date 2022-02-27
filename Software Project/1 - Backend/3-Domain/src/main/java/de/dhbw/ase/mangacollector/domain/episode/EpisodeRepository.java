package de.dhbw.ase.mangacollector.domain.episode;

import java.util.List;

public interface EpisodeRepository {
    List<Episode> findAll();

    Episode save(Episode episode);
}
