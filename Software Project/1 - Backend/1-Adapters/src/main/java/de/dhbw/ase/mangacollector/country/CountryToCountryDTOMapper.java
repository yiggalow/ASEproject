package de.dhbw.ase.mangacollector.country;


import de.dhbw.ase.mangacollector.domain.country.Country;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CountryToCountryDTOMapper implements Function<Country, CountryDTO> {
    @Override
    public CountryDTO apply(Country country) {
        return map(country);
    }

    private CountryDTO map(Country country) {
        return new CountryDTO(country.getId(), country.getName(), null);
    }

}
