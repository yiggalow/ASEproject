package de.dhbw.ase.mangacollector.rating;

import de.dhbw.ase.mangacollector.manga.MangaDTOtoMangaMapper;
import de.dhbw.ase.mangacollector.rating.RatingDTO;
import de.dhbw.ase.mangacollector.domain.rating.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;


@Component
public class RatingDTOtoRatingMapper  implements Function<RatingDTO, Rating> {

    @Override
    public Rating apply(RatingDTO ratingDTO) {
        return map(ratingDTO);
    }

    private Rating map(RatingDTO ratingDTO) {
        return new Rating(ratingDTO.getId(), ratingDTO.getRater(), ratingDTO.getRating());
    }

}
