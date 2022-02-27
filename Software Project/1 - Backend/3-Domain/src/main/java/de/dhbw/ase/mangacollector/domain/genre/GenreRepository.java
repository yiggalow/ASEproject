package de.dhbw.ase.mangacollector.domain.genre;

import java.util.List;

public interface GenreRepository {
    List<Genre> findAll();

    Genre save(Genre genre);
}
