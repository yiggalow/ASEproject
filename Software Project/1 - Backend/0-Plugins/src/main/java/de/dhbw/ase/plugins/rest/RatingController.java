package de.dhbw.ase.plugins.rest;

import de.dhbw.ase.mangacollector.rating.RatingApplicationService;
import de.dhbw.ase.mangacollector.rating.RatingDTO;
import de.dhbw.ase.mangacollector.rating.RatingDTOtoRatingMapper;
import de.dhbw.ase.mangacollector.rating.RatingToRatingDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@RestController
@RequestMapping("/rating")
public class RatingController {
    private RatingApplicationService ratingApplicationService;
    private RatingToRatingDTOMapper ratingToRatingDTOMapper;
    private RatingDTOtoRatingMapper ratingDTOtoRatingMapper;

    @Autowired
    public RatingController(RatingApplicationService ratingApplicationService,RatingToRatingDTOMapper ratingToRatingDTOMapper,RatingDTOtoRatingMapper ratingDTOtoRatingMapper){
        this.ratingApplicationService = ratingApplicationService;
        this.ratingToRatingDTOMapper = ratingToRatingDTOMapper;
        this.ratingDTOtoRatingMapper = ratingDTOtoRatingMapper;
    }

    @PostMapping("")
    public RatingDTO createRating(@RequestParam Integer mangaID,@RequestBody RatingDTO ratingDTO) throws ClassNotFoundException {
        return ratingToRatingDTOMapper.apply(ratingApplicationService.createRating(mangaID,ratingDTOtoRatingMapper.apply(ratingDTO)));
    }
}
