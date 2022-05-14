package de.dhbw.ase.mangacollector;

import de.dhbw.ase.mangacollector.domain.author.Author;
import de.dhbw.ase.mangacollector.domain.author.AuthorRepository;
import de.dhbw.ase.mangacollector.domain.country.Country;
import de.dhbw.ase.mangacollector.domain.country.CountryRepository;
import de.dhbw.ase.mangacollector.domain.episode.Episode;
import de.dhbw.ase.mangacollector.domain.episode.EpisodeRepository;
import de.dhbw.ase.mangacollector.domain.genre.Genre;
import de.dhbw.ase.mangacollector.domain.genre.GenreRepository;
import de.dhbw.ase.mangacollector.domain.manga.Manga;
import de.dhbw.ase.mangacollector.domain.manga.MangaRepository;
import de.dhbw.ase.mangacollector.domain.publisher.Publisher;
import de.dhbw.ase.mangacollector.domain.publisher.PublisherRepository;
import de.dhbw.ase.mangacollector.domain.rating.Rating;
import de.dhbw.ase.mangacollector.domain.rating.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class DataInserter implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    CountryRepository countryRepository;
    @Autowired
    EpisodeRepository episodeRepository;
    @Autowired
    GenreRepository genreRepository;
    @Autowired
    MangaRepository mangaRepository;
    @Autowired
    PublisherRepository publisherRepository;
    @Autowired
    RatingRepository ratingRepository;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {

        Author author = new Author("Akira Toriyama");
        authorRepository.save(author);

        Author author2 = new Author("Masashi Kishimoto");
        authorRepository.save(author2);

        Country country = new Country("Germany");
        countryRepository.save(country);

        Country country2 = new Country("Japan");
        countryRepository.save(country2);

        Genre genre = new Genre("Shonen");
        genreRepository.save(genre);

        Genre genre2 = new Genre("Shōnen Jump");
        genreRepository.save(genre2);

        Publisher publisher = new Publisher("Carlsen Manga", country);
        publisherRepository.save(publisher);

        Publisher publisher2 = new Publisher("Kaze Manga", country);
        publisherRepository.save(publisher2);

        Publisher publisher3 = new Publisher("Aniverse Manga", country);
        publisherRepository.save(publisher3);

        Publisher publisher4 = new Publisher("Manga Cult", country);
        publisherRepository.save(publisher4);

        Manga manga = new Manga("Dragonball", publisher, author, genre );
        mangaRepository.save(manga);

        Manga manga2 = new Manga("Naruto", publisher2, author2, genre2 );
        mangaRepository.save(manga2);

        Episode episode = new Episode("Das Geheimnis der Drachenkugeln", manga);
        episodeRepository.save(episode);

        Episode episode2 = new Episode("Der Meister des Kamehameha", manga);
        episodeRepository.save(episode2);

        Episode episode1Naruto = new Episode("Band 1", manga2);
        episodeRepository.save(episode1Naruto);

        Rating rating = new Rating("Danny Kroll",manga,1);
        ratingRepository.save(rating);
    }
}
