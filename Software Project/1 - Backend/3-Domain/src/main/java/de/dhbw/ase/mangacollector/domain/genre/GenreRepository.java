package de.dhbw.ase.mangacollector.domain.genre;

import java.util.List;
import java.util.Optional;

public interface GenreRepository {
    List<Genre> findAll();

    Optional<Genre> findById(Integer genreID);

    Genre save(Genre genre);
}
