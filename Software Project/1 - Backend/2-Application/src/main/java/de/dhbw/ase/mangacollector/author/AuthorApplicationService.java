package de.dhbw.ase.mangacollector.author;

import de.dhbw.ase.mangacollector.domain.author.Author;
import de.dhbw.ase.mangacollector.domain.author.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorApplicationService {
    private AuthorRepository authorRepository;
    @Autowired
    public AuthorApplicationService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    public List<Author> getBottles() {         return authorRepository.findAll();     }
}
