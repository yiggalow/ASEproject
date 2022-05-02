package de.dhbw.ase.plugins.rest;

import de.dhbw.ase.mangacollector.author.AuthorApplicationService;
import de.dhbw.ase.mangacollector.author.AuthorDTO;
import de.dhbw.ase.mangacollector.author.AuthorDTOtoAuthorMapper;
import de.dhbw.ase.mangacollector.author.AuthorToAuthorDTOMapper;
import de.dhbw.ase.mangacollector.manga.MangaDTO;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@RestController
@RequestMapping("/author")
public class AuthorController {
    private AuthorApplicationService authorApplicationService;
    private AuthorToAuthorDTOMapper authorToAuthorDTOMapper;
    private AuthorDTOtoAuthorMapper authorDTOtoAuthorMapper;

    @Autowired
    public AuthorController(AuthorApplicationService authorApplicationService, AuthorToAuthorDTOMapper authorToAuthorDTOMapper,AuthorDTOtoAuthorMapper authorDTOtoAuthorMapper){
        this.authorApplicationService = authorApplicationService;
        this.authorToAuthorDTOMapper = authorToAuthorDTOMapper;
        this.authorDTOtoAuthorMapper = authorDTOtoAuthorMapper;
    }

    @GetMapping("/{id}")
    public AuthorDTO findAuthorById(@PathVariable("id") int id) throws NotFoundException {
        return authorToAuthorDTOMapper.apply(authorApplicationService.getAuthorById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteAuthorById(@PathVariable("id") int id) throws NotFoundException {
        authorApplicationService.deleteAuthor(id);
    }
    
    @PostMapping("")
    public AuthorDTO createAuthor(@RequestBody AuthorDTO authorDTO){
        return authorToAuthorDTOMapper.apply(authorApplicationService.createAuthor(authorDTOtoAuthorMapper.apply(authorDTO)));
    }

    @PutMapping("")
    public AuthorDTO updateAuthor(@RequestBody AuthorDTO authorDTO)throws NotFoundException {
        return authorToAuthorDTOMapper.apply(authorApplicationService.updateAuthor(authorDTOtoAuthorMapper.apply(authorDTO)));
    }

    @GetMapping("")
    public List<AuthorDTO> getAllAuthors(){
        return authorApplicationService.getAuthors().stream().map(authorToAuthorDTOMapper).collect(Collectors.toList());
    }
}
