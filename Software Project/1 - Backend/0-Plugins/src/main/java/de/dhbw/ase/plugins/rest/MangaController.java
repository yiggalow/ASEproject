package de.dhbw.ase.plugins.rest;

import de.dhbw.ase.mangacollector.domain.manga.Manga;
import de.dhbw.ase.mangacollector.manga.MangaApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@RestController
@RequestMapping("/manga")
public class MangaController {
    private MangaApplicationService mangaApplicationService;

    @Autowired
    public MangaController(MangaApplicationService mangaApplicationService) {
        this.mangaApplicationService = mangaApplicationService;
    }

    @GetMapping("")
    public List<Manga> getAllMangas() {
        return mangaApplicationService.getMangas();
    }

    @GetMapping("/{id}")
    public List<Manga> findAllById(@PathVariable int id) { return mangaApplicationService.findAllByGenre_Id(id);}

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) { mangaApplicationService.delteManga(id);}
}
