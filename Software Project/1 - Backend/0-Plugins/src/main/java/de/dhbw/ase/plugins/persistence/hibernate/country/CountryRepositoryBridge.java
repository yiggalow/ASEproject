package de.dhbw.ase.plugins.persistence.hibernate.country;

import de.dhbw.ase.mangacollector.domain.country.Country;
import de.dhbw.ase.mangacollector.domain.country.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryRepositoryBridge implements CountryRepository {
    private SpringDataCountryRepository springDataCountryRepository;
    @Autowired
    public CountryRepositoryBridge(SpringDataCountryRepository springDataCountryRepository){
        this.springDataCountryRepository = springDataCountryRepository;
    }

    @Override
    public List<Country> findAll() {
        return springDataCountryRepository.findAll();
    }

    @Override
    public Country save(Country country){
        return springDataCountryRepository.save(country);
    }
}
