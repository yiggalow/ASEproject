package de.dhbw.ase.plugins.rest;

import de.dhbw.ase.mangacollector.genre.GenreApplicationService;
import de.dhbw.ase.mangacollector.genre.GenreDTO;
import de.dhbw.ase.mangacollector.genre.GenreToGenreDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@RestController
@RequestMapping("/genre")
public class GenreController {
    private GenreApplicationService genreApplicationService;
    private GenreToGenreDTOMapper genreToGenreDTOMapper;
    @Autowired
    public GenreController(GenreApplicationService genreApplicationService, GenreToGenreDTOMapper genreToGenreDTOMapper){
        this.genreApplicationService = genreApplicationService;
        this.genreToGenreDTOMapper = genreToGenreDTOMapper;
    }
    @GetMapping("")
    public List<GenreDTO> getAllGenres() {
        return genreApplicationService.getGenres().stream().map(genreToGenreDTOMapper).collect(Collectors.toList());
    }
}
