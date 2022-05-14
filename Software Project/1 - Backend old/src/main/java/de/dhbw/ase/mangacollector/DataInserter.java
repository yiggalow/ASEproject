package de.dhbw.ase.mangacollector;

import de.dhbw.ase.mangacollector.model.*;
import de.dhbw.ase.mangacollector.repository.*;
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

        Country country = new Country("Deutschland");
        countryRepository.save(country);

        Publisher publisher = new Publisher("Carlsen", country);
        publisherRepository.save(publisher);

        Genre genre = new Genre("Shonen");
        genreRepository.save(genre);

        Author author = new Author("Akira Toriyama");
        authorRepository.save(author);

        Manga manga = new Manga("Dragonball", publisher, author, genre);
        mangaRepository.save(manga);

        Episode episode = new Episode("Das Geheimnis der Drachenkugel", manga);
        episodeRepository.save(episode);

    }
}
