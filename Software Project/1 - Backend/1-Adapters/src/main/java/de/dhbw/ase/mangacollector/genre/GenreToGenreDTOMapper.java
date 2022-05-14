package de.dhbw.ase.mangacollector.genre;

import de.dhbw.ase.mangacollector.domain.genre.Genre;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class GenreToGenreDTOMapper implements Function<Genre, GenreDTO> {
    @Override
    public GenreDTO apply(Genre genre) {
        return map(genre);
    }

    private GenreDTO map(Genre genre) {
        return new GenreDTO(genre.getId(), genre.getName(), null);
    }

}
