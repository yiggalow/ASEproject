package de.dhbw.ase.mangacollector.domain.country;

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
@Table(name = "Country")
public class Country {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="country_id")
    private Integer id;

    @Column(name="name")
    private String name;

    public Country(String country) {
        this.name = country;
    }
}
