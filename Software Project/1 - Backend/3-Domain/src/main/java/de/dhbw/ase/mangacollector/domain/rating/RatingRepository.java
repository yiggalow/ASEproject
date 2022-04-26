package de.dhbw.ase.mangacollector.domain.rating;


import java.util.List;

public interface RatingRepository {

    List<Rating> findAll();

    Rating save(Rating rating);

    void deleteById(int ratingId);

}
