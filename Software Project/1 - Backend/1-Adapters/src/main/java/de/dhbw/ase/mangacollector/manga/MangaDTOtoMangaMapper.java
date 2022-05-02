package de.dhbw.ase.mangacollector.manga;

import de.dhbw.ase.mangacollector.author.AuthorDTOtoAuthorMapper;
import de.dhbw.ase.mangacollector.domain.manga.Manga;
import de.dhbw.ase.mangacollector.episode.EpisodeDTOtoEpisodeMapper;
import de.dhbw.ase.mangacollector.genre.GenreDTOtoGenreMapper;
import de.dhbw.ase.mangacollector.publisher.PublisherDTOtoPublisherMapper;
import de.dhbw.ase.mangacollector.rating.RatingDTOtoRatingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.stream.Collectors;


@Component
public class MangaDTOtoMangaMapper  implements Function<MangaDTO, Manga> {

    private GenreDTOtoGenreMapper genreDTOtoGenreMapper;
    private AuthorDTOtoAuthorMapper authorDTOtoAuthorMapper;
    private PublisherDTOtoPublisherMapper publisherDTOtoPublisherMapper;
    private EpisodeDTOtoEpisodeMapper episodeDTOtoEpisodeMapper;
    private RatingDTOtoRatingMapper ratingDTOtoRatingMapper;
    @Autowired
    public MangaDTOtoMangaMapper(GenreDTOtoGenreMapper genreDTOtoGenreMapper,
                                 AuthorDTOtoAuthorMapper authorDTOtoAuthorMapper,
                                 PublisherDTOtoPublisherMapper publisherDTOtoPublisherMapper,
                                 EpisodeDTOtoEpisodeMapper episodeDTOtoEpisodeMapper,
                                 RatingDTOtoRatingMapper ratingDTOtoRatingMapper) {
        this.genreDTOtoGenreMapper = genreDTOtoGenreMapper;
        this.authorDTOtoAuthorMapper = authorDTOtoAuthorMapper;
        this.publisherDTOtoPublisherMapper = publisherDTOtoPublisherMapper;
        this.episodeDTOtoEpisodeMapper = episodeDTOtoEpisodeMapper;
        this.ratingDTOtoRatingMapper = ratingDTOtoRatingMapper;
    }


    @Override
    public Manga apply(MangaDTO mangaDTO) {
        return map(mangaDTO);
    }

    private Manga map(MangaDTO mangaDTO) {
        return new Manga(mangaDTO.getId(),
                mangaDTO.getName(),
                publisherDTOtoPublisherMapper.apply(mangaDTO.getPublisher()),
                authorDTOtoAuthorMapper.apply(mangaDTO.getAuthor()),
                genreDTOtoGenreMapper.apply(mangaDTO.getGenre()),
                mangaDTO.getEpisodeList().stream().map(episodeDTOtoEpisodeMapper).collect(Collectors.toList()),
                mangaDTO.getRatingList().stream().map(ratingDTOtoRatingMapper).collect(Collectors.toList())
                );
    }

}
