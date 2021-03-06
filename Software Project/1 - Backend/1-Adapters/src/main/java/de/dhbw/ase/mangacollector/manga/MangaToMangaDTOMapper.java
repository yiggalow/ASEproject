package de.dhbw.ase.mangacollector.manga;

import de.dhbw.ase.mangacollector.author.AuthorToAuthorDTOMapper;
import de.dhbw.ase.mangacollector.domain.manga.Manga;
import de.dhbw.ase.mangacollector.episode.EpisodeToEpisodeDTOMapper;
import de.dhbw.ase.mangacollector.genre.GenreToGenreDTOMapper;
import de.dhbw.ase.mangacollector.publisher.PublisherToPublisherDTOMapper;
import de.dhbw.ase.mangacollector.rating.RatingToRatingDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class MangaToMangaDTOMapper  implements Function<Manga, MangaDTO> {

    private GenreToGenreDTOMapper genreToGenreDTOMapper;
    private AuthorToAuthorDTOMapper authorToAuthorDTOMapper;
    private PublisherToPublisherDTOMapper publisherToPublisherDTOMapper;
    private EpisodeToEpisodeDTOMapper episodeToEpisodeDTOMapper;
    private RatingToRatingDTOMapper ratingToRatingDTOMapper;


    @Autowired
    public MangaToMangaDTOMapper(GenreToGenreDTOMapper genreToGenreDTOMapper,
                                 AuthorToAuthorDTOMapper authorToAuthorDTOMapper,
                                 PublisherToPublisherDTOMapper publisherToPublisherDTOMapper,
                                 EpisodeToEpisodeDTOMapper episodeToEpisodeDTOMapper,
                                 RatingToRatingDTOMapper ratingToRatingDTOMapper) {
        this.genreToGenreDTOMapper = genreToGenreDTOMapper;
        this.authorToAuthorDTOMapper = authorToAuthorDTOMapper;
        this.publisherToPublisherDTOMapper = publisherToPublisherDTOMapper;
        this.episodeToEpisodeDTOMapper = episodeToEpisodeDTOMapper;
        this.ratingToRatingDTOMapper = ratingToRatingDTOMapper;
    }


    @Override
    public MangaDTO apply(Manga manga) {
        return map(manga);
    }

    private MangaDTO map(Manga manga) {
        return new MangaDTO(manga.getId(),
                manga.getName(),
                publisherToPublisherDTOMapper.apply(manga.getPublisher()),
                authorToAuthorDTOMapper.apply(manga.getAuthor()),
                genreToGenreDTOMapper.apply(manga.getGenre()),
                manga.getEpisodeList().stream().map(episodeToEpisodeDTOMapper).collect(Collectors.toList()),
                manga.getRatingList().stream().map(ratingToRatingDTOMapper).collect(Collectors.toList()),
                null
        );
    }

}
