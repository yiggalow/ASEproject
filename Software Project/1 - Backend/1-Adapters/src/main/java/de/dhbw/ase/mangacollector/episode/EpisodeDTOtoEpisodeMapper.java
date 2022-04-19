package de.dhbw.ase.mangacollector.episode;

import de.dhbw.ase.mangacollector.domain.episode.Episode;
import de.dhbw.ase.mangacollector.manga.MangaDTOtoMangaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class EpisodeDTOtoEpisodeMapper  implements Function<EpisodeDTO, Episode> {

    @Override
    public Episode apply(EpisodeDTO episodeDTO) {
        return map(episodeDTO);
    }

    private Episode map(EpisodeDTO episodeDTO) {
        return new Episode(episodeDTO.getId(), episodeDTO.getTitle(), null);
    }
}
