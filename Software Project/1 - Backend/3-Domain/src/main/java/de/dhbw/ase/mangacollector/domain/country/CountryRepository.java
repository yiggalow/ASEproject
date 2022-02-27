package de.dhbw.ase.mangacollector.domain.country;

import de.dhbw.ase.mangacollector.domain.author.Author;

import java.util.List;

public interface CountryRepository {
    List<Country> findAll();

    Country save(Country country);
}
