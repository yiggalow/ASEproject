package de.dhbw.ase.mangacollector.publisher;

import de.dhbw.ase.mangacollector.country.CountryDTOtoCountryMapper;
import de.dhbw.ase.mangacollector.domain.publisher.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;


@Component
public class PublisherDTOtoPublisherMapper  implements Function<PublisherDTO, Publisher> {

    private CountryDTOtoCountryMapper countryDTOToCountryMapper;
    @Autowired
    public PublisherDTOtoPublisherMapper(CountryDTOtoCountryMapper countryDTOtoCountryMapper) {
        this.countryDTOToCountryMapper = countryDTOtoCountryMapper;
    }

    @Override
    public Publisher apply(PublisherDTO publisherDTO) {
        return map(publisherDTO);
    }

    private Publisher map(PublisherDTO publisherDTO) {
        return new Publisher(publisherDTO.getId(), publisherDTO.getName(), countryDTOToCountryMapper.apply(publisherDTO.getOriginCountry()));
    }

}
