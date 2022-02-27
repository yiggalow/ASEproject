package de.dhbw.ase.plugins.rest;

import de.dhbw.ase.mangacollector.domain.manga.Manga;
import de.dhbw.ase.mangacollector.manga.MangaApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@RestController
@RequestMapping("/manga")
public class MangaController {
    private MangaApplicationService mangaApplicationService;
    @Autowired
    public MangaController(MangaApplicationService mangaApplicationService){
        this.mangaApplicationService = mangaApplicationService;
    }
    @GetMapping("")
    public List<Manga> getAllMangas() {
        return mangaApplicationService.getMangas();
    }
}
