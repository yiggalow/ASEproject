package de.dhbw.ase.mangacollector.author;

import de.dhbw.ase.mangacollector.domain.author.Author;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class AuthorToAuthorDTOMapper implements Function< Author,  AuthorDTO> {
    @Override
    public  AuthorDTO apply( Author author) {
        return map(author);
    }

    private  AuthorDTO map(Author author) {
        return new  AuthorDTO(author.getId(), author.getName(), null);
    }

}
