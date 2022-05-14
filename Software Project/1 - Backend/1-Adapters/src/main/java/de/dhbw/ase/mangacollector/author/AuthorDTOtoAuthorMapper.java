package de.dhbw.ase.mangacollector.author;

import de.dhbw.ase.mangacollector.domain.author.Author;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class AuthorDTOtoAuthorMapper  implements Function<AuthorDTO, Author> {

    @Override
    public Author apply(AuthorDTO authorDTO) {
        return map(authorDTO);
    }

    private Author map(AuthorDTO authorDTO) {
        return new Author(authorDTO.getId(), authorDTO.getName());
    }

}
