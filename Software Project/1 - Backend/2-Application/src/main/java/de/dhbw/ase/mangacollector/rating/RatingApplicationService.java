package de.dhbw.ase.mangacollector.rating;

import de.dhbw.ase.mangacollector.domain.manga.Manga;
import de.dhbw.ase.mangacollector.domain.manga.MangaRepository;
import de.dhbw.ase.mangacollector.domain.rating.Rating;
import de.dhbw.ase.mangacollector.domain.rating.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingApplicationService {
    private RatingRepository ratingRepository;
    private MangaRepository mangaRepository;

    @Autowired
    public RatingApplicationService(RatingRepository ratingRepository,MangaRepository mangaRepository){
        this.ratingRepository = ratingRepository;
        this.mangaRepository = mangaRepository;
    }

    public List<Rating> getRatings() {         return ratingRepository.findAll();     }

    public Rating createRating(Integer mangaID,Rating rating) throws ClassNotFoundException {
        Optional<Manga> foundManga = mangaRepository.findById(mangaID);
        if(foundManga.isPresent()){
            Rating toCreate = new Rating(rating.getRater(), foundManga.get(), rating.getRatingValue());
            ratingRepository.save(toCreate);
            return toCreate;
        }
        throw new ClassNotFoundException("Manga with the id not found!");
    }

}
