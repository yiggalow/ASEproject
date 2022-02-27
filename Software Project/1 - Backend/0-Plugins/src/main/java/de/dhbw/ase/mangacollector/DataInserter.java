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

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {


        Author author = new Author("Akira Toriyama");
        authorRepository.save(author);

        Country country = new Country("Germany");
        countryRepository.save(country);

        Genre genre = new Genre("Shonen");
        genreRepository.save(genre);

        Publisher publisher = new Publisher("Carlsen Manga", country);
        publisherRepository.save(publisher);

        Manga manga = new Manga("Dragonball", publisher, author, genre );
        mangaRepository.save(manga);

        Episode episode = new Episode("Das Geheimnis der Drachenkugeln", manga);
        episodeRepository.save(episode);




    }
}
