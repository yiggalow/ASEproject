package de.dhbw.ase.mangacollector.country;

import de.dhbw.ase.mangacollector.domain.country.Country;
import de.dhbw.ase.mangacollector.domain.country.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryApplicationService {
    private CountryRepository countryRepository;
    @Autowired
    public CountryApplicationService(CountryRepository countryRepository){
        this.countryRepository = countryRepository;
    }

    public List<Country> getCountries() {         return countryRepository.findAll();     }
}
