package de.dhbw.ase.mangacollector.country;


import de.dhbw.ase.mangacollector.domain.country.Country;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CountryDTOtoCountryMapper  implements Function<CountryDTO, Country> {

    @Override
    public Country apply(CountryDTO countryDTO) {
        return map(countryDTO);
    }

    private Country map(CountryDTO countryDTO) {
        return new Country(countryDTO.getId(), countryDTO.getName());
    }

}
