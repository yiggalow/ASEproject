package de.dhbw.ase.mangacollector.publisher;

import de.dhbw.ase.mangacollector.country.CountryToCountryDTOMapper;
import de.dhbw.ase.mangacollector.domain.publisher.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class PublisherToPublisherDTOMapper implements Function<Publisher, PublisherDTO> {
    private CountryToCountryDTOMapper countryToCountryDTOMapper;

    @Autowired
    public PublisherToPublisherDTOMapper(CountryToCountryDTOMapper countryToCountryDTOMapper) {
        this.countryToCountryDTOMapper = countryToCountryDTOMapper;
    }
    @Override
    public PublisherDTO apply(Publisher publisher) {
        return map(publisher);
    }

    private PublisherDTO map(Publisher publisher) {
        return new PublisherDTO(publisher.getId(), publisher.getName(), countryToCountryDTOMapper.apply(publisher.getOriginCountry()),null);
    }
}
