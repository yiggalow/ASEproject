package de.dhbw.ase.plugins.persistence.hibernate.episode;

import de.dhbw.ase.mangacollector.domain.episode.Episode;
import de.dhbw.ase.mangacollector.domain.episode.EpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EpisodeRepositoryBridge implements EpisodeRepository {
    private SpringDataEpisodeRepository springDataEpisodeRepository;
    @Autowired
    public EpisodeRepositoryBridge(SpringDataEpisodeRepository springDataEpisodeRepository){
        this.springDataEpisodeRepository = springDataEpisodeRepository;
    }

    @Override
    public List<Episode> findAll() {
        return springDataEpisodeRepository.findAll();
    }

    @Override
    public Episode save(Episode episode) {
        return springDataEpisodeRepository.save(episode);
    }
}
