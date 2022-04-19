package de.dhbw.ase.mangacollector.domain.manga;

import java.util.List;

public interface MangaRepository {
    List<Manga> findAll();

    Manga save(Manga manga);

    void deleteById(int id);

    List<Manga> findAllByGenre_Id(int genreId);

}
