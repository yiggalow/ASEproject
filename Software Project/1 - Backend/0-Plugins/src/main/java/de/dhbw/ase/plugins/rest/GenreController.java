package de.dhbw.ase.plugins.rest;

import de.dhbw.ase.mangacollector.domain.genre.Genre;
import de.dhbw.ase.mangacollector.genre.GenreApplicationService;
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
@RequestMapping("/genre")
public class GenreController {
    private GenreApplicationService genreApplicationService;
    @Autowired
    public GenreController(GenreApplicationService genreApplicationService){
        this.genreApplicationService = genreApplicationService;
    }
    @GetMapping("")
    public List<Genre> getAllGenres() {
        return genreApplicationService.getGenres();
    }
}
