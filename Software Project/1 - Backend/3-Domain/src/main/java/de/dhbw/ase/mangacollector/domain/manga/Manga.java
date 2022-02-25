package de.dhbw.ase.mangacollector.domain.manga;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import de.dhbw.ase.mangacollector.domain.publisher.Publisher;
import de.dhbw.ase.mangacollector.domain.author.Author;
import de.dhbw.ase.mangacollector.domain.episode.Episode;
import de.dhbw.ase.mangacollector.domain.genre.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "Manga")
public class Manga {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="manga_id")
    private Integer id;

    @Column(name="name")
    private String name;

    @ManyToOne
    @JoinColumn (name= "publisher")
    private Publisher publisher;

    @ManyToOne
    @JoinColumn (name= "author")
    private Author author;

    @ManyToOne
    @JoinColumn (name= "genre")
    private Genre genre;

    @OneToMany (cascade = CascadeType.PERSIST, mappedBy="manga")
    @JsonIgnoreProperties("manga")
    private List<Episode> episodeList = new LinkedList<>();

    public Manga(String name, Publisher publisher, Author author, Genre genre) {
        this.name = name;
        this.publisher =publisher;
        this.author = author;
        this.genre = genre;
    }
}
