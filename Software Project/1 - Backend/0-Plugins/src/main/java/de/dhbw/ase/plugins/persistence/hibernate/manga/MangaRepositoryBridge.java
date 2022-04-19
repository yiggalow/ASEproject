package de.dhbw.ase.plugins.persistence.hibernate.manga;

import de.dhbw.ase.mangacollector.domain.manga.Manga;
import de.dhbw.ase.mangacollector.domain.manga.MangaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MangaRepositoryBridge implements MangaRepository {
    private SpringDataMangaRepository springDataMangaRepository;
    @Autowired
    public MangaRepositoryBridge(SpringDataMangaRepository springDataMangaRepository){
        this.springDataMangaRepository = springDataMangaRepository;
    }

    @Override
    public List<Manga> findAll() {
        return springDataMangaRepository.findAll();
    }

    @Override
    public Manga save(Manga manga) {
        return springDataMangaRepository.save(manga);
    }

    @Override
    public void deleteById(int id) {
        springDataMangaRepository.deleteById(id);
    }

    @Override
    public List<Manga> findAllByGenre_Id(int genreId) {
        return springDataMangaRepository.findAllByGenre_Id(genreId);
    }
}
