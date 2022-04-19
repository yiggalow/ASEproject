package de.dhbw.ase.plugins.rest;

import de.dhbw.ase.mangacollector.author.AuthorApplicationService;
import de.dhbw.ase.mangacollector.author.AuthorDTO;
import de.dhbw.ase.mangacollector.author.AuthorToAuthorDTOMapper;
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
@RequestMapping("/author")
public class AuthorController {
    private AuthorApplicationService authorApplicationService;
    private AuthorToAuthorDTOMapper authorToAuthorDTOMapper;
    @Autowired
    public AuthorController(AuthorApplicationService authorApplicationService, AuthorToAuthorDTOMapper authorToAuthorDTOMapper){
        this.authorApplicationService = authorApplicationService;
        this.authorToAuthorDTOMapper = authorToAuthorDTOMapper;
    }
    @GetMapping("")
    public List<AuthorDTO> getAllAuthors() {
        return authorApplicationService.getAuthors().stream().map(authorToAuthorDTOMapper).collect(Collectors.toList());
    }
}
