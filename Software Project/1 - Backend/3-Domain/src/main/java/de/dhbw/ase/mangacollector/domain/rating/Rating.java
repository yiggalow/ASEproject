package de.dhbw.ase.mangacollector.domain.rating;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import de.dhbw.ase.mangacollector.domain.manga.Manga;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "Rating")
public class Rating {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="rating_id")
    private Integer id;

    @Column(name="rater")
    private String rater;

    @Column(name="rating")
    private Integer rating;

    @ManyToOne
    @JoinColumn (name= "manga")
    @JsonIgnoreProperties
    private Manga manga;

    public Rating(Integer id,String rater,Integer rating) {
        this.id = id;
        this.rater = rater;
        this.rating = rating;
    }

    public Rating(String rater, Manga manga, Integer rating) {
        this.rater = rater;
        this.manga = manga;
        this.rating = rating;
    }
}
