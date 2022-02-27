package de.dhbw.ase.mangacollector.episode;

import de.dhbw.ase.mangacollector.domain.episode.Episode;
import de.dhbw.ase.mangacollector.domain.episode.EpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpisodeApplicationService {
    private EpisodeRepository episodeRepository;
    @Autowired
    public EpisodeApplicationService(EpisodeRepository episodeRepository){
        this.episodeRepository = episodeRepository;
    }

    public List<Episode> getEpisodes() {         return episodeRepository.findAll();     }
}
