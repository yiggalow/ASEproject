package de.dhbw.ase.mangacollector.manga;

import de.dhbw.ase.mangacollector.domain.manga.Manga;
import de.dhbw.ase.mangacollector.domain.manga.MangaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MangaApplicationService {
    private MangaRepository mangaRepository;
    @Autowired
    public MangaApplicationService(MangaRepository mangaRepository){
        this.mangaRepository = mangaRepository;
    }

    public List<Manga> getMangas() {         return mangaRepository.findAll();     }
}
