package de.dhbw.ase.plugins.persistence.hibernate.rating;

import de.dhbw.ase.mangacollector.domain.rating.Rating;
import de.dhbw.ase.mangacollector.domain.rating.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RatingRepositoryBridge implements RatingRepository {
    private SpringDataRatingRepository springDataRatingRepository;
    @Autowired
    public RatingRepositoryBridge(SpringDataRatingRepository springDataRatingRepository){
        this.springDataRatingRepository = springDataRatingRepository;
    }

    @Override
    public List<Rating> findAll() {
        return springDataRatingRepository.findAll();
    }

    @Override
    public Rating save(Rating rating){
        return springDataRatingRepository.save(rating);
    }

    @Override
    public void deleteById(int ratingId) {
        springDataRatingRepository.deleteById(ratingId);
    }
}
