package de.dhbw.ase.mangacollector.rating;

import de.dhbw.ase.mangacollector.domain.rating.Rating;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class RatingToRatingDTOMapper implements Function<Rating, RatingDTO> {

    @Override
    public RatingDTO apply(Rating rating) {
        return map(rating);
    }

    private RatingDTO map(Rating rating) {
        return new RatingDTO(rating.getId(), rating.getRater(),rating.getRatingValue(),null);
    }

}
