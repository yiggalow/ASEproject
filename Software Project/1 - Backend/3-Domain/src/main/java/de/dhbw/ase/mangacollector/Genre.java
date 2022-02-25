package de.dhbw.ase.mangacollector;

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
@Table(name = "Genre")
public class Genre {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="genre_id")
    private Integer id;

    @Column(name="name")
    private String name;

    public Genre(String name) {
        this.name = name;
    }
}
