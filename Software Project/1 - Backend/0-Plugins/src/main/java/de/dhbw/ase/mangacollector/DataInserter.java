package de.dhbw.ase.mangacollector;

import de.dhbw.ase.mangacollector.domain.author.Author;
import de.dhbw.ase.mangacollector.domain.author.AuthorRepository;
import de.dhbw.ase.mangacollector.domain.country.CountryRepository;
import de.dhbw.ase.mangacollector.domain.episode.EpisodeRepository;
import de.dhbw.ase.mangacollector.domain.genre.GenreRepository;
import de.dhbw.ase.mangacollector.domain.manga.MangaRepository;
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

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {


        Author author = new Author("Akira Toriyama");
        authorRepository.save(author);

    }
}
