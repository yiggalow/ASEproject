package de.dhbw.ase.plugins.persistence.hibernate.genre;

import de.dhbw.ase.mangacollector.domain.genre.Genre;
import de.dhbw.ase.mangacollector.domain.genre.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GenreRepositoryBridge implements GenreRepository {
    private SpringDataGenreRepository springDataGenreRepository;
    @Autowired
    public GenreRepositoryBridge(SpringDataGenreRepository springDataGenreRepository){
        this.springDataGenreRepository = springDataGenreRepository;
    }

    @Override
    public List<Genre> findAll() {
        return springDataGenreRepository.findAll();
    }

    @Override
    public Genre save(Genre genre) {
        return springDataGenreRepository.save(genre);
    }
}
