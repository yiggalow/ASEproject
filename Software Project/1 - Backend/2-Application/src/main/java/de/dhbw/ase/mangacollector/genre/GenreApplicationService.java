package de.dhbw.ase.mangacollector.genre;

import de.dhbw.ase.mangacollector.domain.genre.Genre;
import de.dhbw.ase.mangacollector.domain.genre.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreApplicationService {
    private GenreRepository genreRepository;
    @Autowired
    public GenreApplicationService(GenreRepository genreRepository){
        this.genreRepository = genreRepository;
    }

    public List<Genre> getGenres() {         return genreRepository.findAll();     }
}
