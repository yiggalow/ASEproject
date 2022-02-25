package de.dhbw.ase.mangacollector.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "Episode")
public class Episode {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="episode_id")
    private Integer id;

    @Column(name="title")
    private String title;

    @ManyToOne
    @JsonIgnoreProperties("episodeList")
    @JoinColumn (name= "manga_id")
    private Manga manga;

    public Episode(String title, Manga manga) {
        this.title = title;
        this.manga = manga;
    }
}
