package de.dhbw.ase.plugins.rest;

import de.dhbw.ase.mangacollector.author.AuthorApplicationService;
import de.dhbw.ase.mangacollector.domain.author.Author;
import de.dhbw.ase.mangacollector.domain.author.AuthorRepository;
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
@RequestMapping("/author")
public class AuthorController {
    private AuthorApplicationService authorApplicationService;
    @Autowired
    public AuthorController(AuthorApplicationService authorApplicationService){
        this.authorApplicationService = authorApplicationService;
    }
    @GetMapping("")
    public List<Author> getAllAuthors() {
        return authorApplicationService.getBottles();
    }
}
