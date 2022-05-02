package de.dhbw.ase.mangacollector.manga;

import java.util.Optional;
import de.dhbw.ase.mangacollector.domain.author.AuthorRepository;
import de.dhbw.ase.mangacollector.domain.country.CountryRepository;
import de.dhbw.ase.mangacollector.domain.episode.Episode;
import de.dhbw.ase.mangacollector.domain.episode.EpisodeRepository;
import de.dhbw.ase.mangacollector.domain.genre.GenreRepository;
import de.dhbw.ase.mangacollector.domain.manga.Manga;
import de.dhbw.ase.mangacollector.domain.publisher.Publisher;
import de.dhbw.ase.mangacollector.domain.genre.Genre;
import de.dhbw.ase.mangacollector.domain.country.Country;
import de.dhbw.ase.mangacollector.domain.author.Author;
import de.dhbw.ase.mangacollector.domain.manga.MangaRepository;
import de.dhbw.ase.mangacollector.domain.publisher.PublisherRepository;
import de.dhbw.ase.mangacollector.domain.rating.Rating;
import de.dhbw.ase.mangacollector.domain.rating.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MangaApplicationService {
    private PublisherRepository publisherRepository;
    private GenreRepository genreRepository;
    private AuthorRepository authorRepository;
    private MangaRepository mangaRepository;
    private EpisodeRepository episodeRepository;
    private RatingRepository ratingRepository;

    @Autowired
    public MangaApplicationService(
            MangaRepository mangaRepository,
            PublisherRepository publisherRepository,
            GenreRepository genreRepository,
            AuthorRepository authorRepository,
            EpisodeRepository episodeRepository,
            RatingRepository ratingRepository) {
        this.mangaRepository = mangaRepository;
        this.publisherRepository = publisherRepository;
        this.genreRepository = genreRepository;
        this.authorRepository = authorRepository;
        this.episodeRepository = episodeRepository;
        this.ratingRepository = ratingRepository;
    }

    public Manga createManga(Manga manga) throws ClassNotFoundException{
        Optional<Publisher> foundPublisher = publisherRepository.findById(manga.getPublisher().getId());
        Optional<Genre> foundGenre = genreRepository.findById(manga.getGenre().getId());
        Optional<Author> foundAuthor = authorRepository.findById(manga.getAuthor().getId());
        if(foundPublisher.isPresent() && foundGenre.isPresent() && foundAuthor.isPresent()){
            Manga mangaToCreate = new Manga(manga.getName(),foundPublisher.get(),foundAuthor.get(),foundGenre.get());
            mangaRepository.save(mangaToCreate);
            for(Episode episode : manga.getEpisodeList()){
                Episode episodeToCreate = new Episode(episode.getTitle(),mangaToCreate);
                episodeRepository.save(episodeToCreate);
            }
            for(Rating rating : manga.getRatingList()){
                Rating ratingToCreate = new Rating(rating.getRater(),mangaToCreate, rating.getRating());
                ratingRepository.save(ratingToCreate);
            }
            return mangaToCreate;
        }
        throw new ClassNotFoundException("Error creating a new Manga!");
    }

    public Manga updateManga(Manga manga) throws ClassNotFoundException{
        Optional<Manga> foundMangaOptional = mangaRepository.findById(manga.getId());
        Optional<Publisher> foundPublisher = publisherRepository.findById(manga.getPublisher().getId());
        Optional<Genre> foundGenre = genreRepository.findById(manga.getGenre().getId());
        Optional<Author> foundAuthor = authorRepository.findById(manga.getAuthor().getId());
        if(foundMangaOptional.isPresent()){
            Manga foundManga = foundMangaOptional.get();
            if(!foundManga.getName().equals(manga.getName())){
                foundManga.setName(manga.getName());
            }
            if(foundPublisher.isPresent() && !foundPublisher.get().equals(foundManga.getPublisher())){
                foundManga.setPublisher(foundPublisher.get());
            }
            if(foundAuthor.isPresent() && !foundAuthor.get().equals(foundManga.getAuthor())){
                foundManga.setAuthor(foundAuthor.get());
            }
            if(foundGenre.isPresent() && !foundGenre.get().equals(foundManga.getGenre())){
                foundManga.setGenre(foundGenre.get());
            }
            mangaRepository.save(foundManga);
            return foundManga;
        }
        throw new ClassNotFoundException("Error creating a new Manga!");
    }

    public List<Manga> getMangas() {
        return mangaRepository.findAll();
    }

    public List<Manga> findAllByGenre_Id(int id) {
        return mangaRepository.findAllByGenre_Id(id);
    }

    public void delteManga(int id) {
        mangaRepository.deleteById(id);
    }
}
