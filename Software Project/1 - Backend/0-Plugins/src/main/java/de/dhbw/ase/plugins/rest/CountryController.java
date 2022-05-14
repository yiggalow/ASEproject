package de.dhbw.ase.plugins.rest;

import de.dhbw.ase.mangacollector.country.CountryApplicationService;
import de.dhbw.ase.mangacollector.country.CountryDTO;
import de.dhbw.ase.mangacollector.country.CountryToCountryDTOMapper;
import de.dhbw.ase.mangacollector.domain.country.Country;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@RestController
@RequestMapping("/country")
public class CountryController {
    private CountryApplicationService countryApplicationService;
    private CountryToCountryDTOMapper countryToCountryDTOMapper;
    @Autowired
    public  CountryController(CountryApplicationService countryApplicationService, CountryToCountryDTOMapper countryToCountryDTOMapper){
        this.countryApplicationService = countryApplicationService;
        this.countryToCountryDTOMapper = countryToCountryDTOMapper;
    }
    @GetMapping("")
    public List<CountryDTO> getAllCountries() {
        return countryApplicationService.getCountries().stream().map(countryToCountryDTOMapper).collect(Collectors.toList());
    }
}
