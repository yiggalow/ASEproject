package de.dhbw.ase.mangacollector.domain.country;

import de.dhbw.ase.mangacollector.domain.author.Author;

import java.util.Optional;
import java.util.List;

public interface CountryRepository {
    List<Country> findAll();

    Optional<Country> findById(Integer countryId);

    Country save(Country country);

    void deleteById(int countryId);
}
