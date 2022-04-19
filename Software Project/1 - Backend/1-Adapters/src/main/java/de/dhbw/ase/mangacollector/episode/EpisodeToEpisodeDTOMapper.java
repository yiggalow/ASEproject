package de.dhbw.ase.mangacollector.episode;

import de.dhbw.ase.mangacollector.domain.episode.Episode;
import de.dhbw.ase.mangacollector.manga.MangaToMangaDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;


@Component
public class EpisodeToEpisodeDTOMapper  implements Function<Episode, EpisodeDTO> {

    private MangaToMangaDTOMapper mangaToMangaDTOMapper;

    @Autowired
    public EpisodeToEpisodeDTOMapper(MangaToMangaDTOMapper mangaToMangaDTOMapper) {
        this.mangaToMangaDTOMapper = mangaToMangaDTOMapper;
    }


    @Override
    public EpisodeDTO apply(Episode episode) {
        return map(episode);
    }

    private EpisodeDTO map(Episode episode) {
        return new EpisodeDTO(episode.getId(), episode.getTitle(), mangaToMangaDTOMapper.apply(episode.getManga()), null);
    }
}
