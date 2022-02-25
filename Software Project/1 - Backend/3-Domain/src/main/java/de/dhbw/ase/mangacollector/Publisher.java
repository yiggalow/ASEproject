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
@Table(name = "Publisher")
public class Publisher {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="publisher_id")
    private Integer id;

    @Column(name="name")
    private String name;

    @ManyToOne
    @JoinColumn (name= "country")
    private Country originCountry;

    public Publisher(String name, Country country) {
        this.name = name;
        this.originCountry = country;
    }
}

