package de.dhbw.ase.mangacollector.genre;

import de.dhbw.ase.mangacollector.domain.genre.Genre;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class GenreDTOtoGenreMapper  implements Function<GenreDTO, Genre> {

    @Override
    public Genre apply(GenreDTO genreDTO) {
        return map(genreDTO);
    }

    private Genre map(GenreDTO genreDTO) {
        return new Genre(genreDTO.getId(), genreDTO.getName());
    }

}
