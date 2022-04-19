package de.dhbw.ase.plugins.rest;

import de.dhbw.ase.mangacollector.domain.manga.Manga;
import de.dhbw.ase.mangacollector.manga.MangaApplicationService;
import de.dhbw.ase.mangacollector.manga.MangaDTO;
import de.dhbw.ase.mangacollector.manga.MangaToMangaDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@RestController
@RequestMapping("/manga")
public class MangaController {
    private MangaApplicationService mangaApplicationService;
    private MangaToMangaDTOMapper mangaToMangaDTOMapper;

    @Autowired
    public MangaController(MangaApplicationService mangaApplicationService, MangaToMangaDTOMapper mangaToMangaDTOMapper) {
        this.mangaApplicationService = mangaApplicationService;
        this.mangaToMangaDTOMapper = mangaToMangaDTOMapper;
    }

    @GetMapping("")
    public List<MangaDTO> getAllMangas() {
        return mangaApplicationService.getMangas().stream().map(mangaToMangaDTOMapper).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public List<MangaDTO> findAllById(@PathVariable int id) {
        return mangaApplicationService.findAllByGenre_Id(id).stream().map(mangaToMangaDTOMapper).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        mangaApplicationService.delteManga(id);
    }
}
