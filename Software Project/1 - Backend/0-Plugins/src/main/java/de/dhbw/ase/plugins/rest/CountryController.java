package de.dhbw.ase.plugins.rest;

import de.dhbw.ase.mangacollector.country.CountryApplicationService;
import de.dhbw.ase.mangacollector.domain.country.Country;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@RestController
@RequestMapping("/country")
public class CountryController {
    private CountryApplicationService countryApplicationService;
    @Autowired
    public  CountryController(CountryApplicationService countryApplicationService){
        this.countryApplicationService = countryApplicationService;
    }
    @GetMapping("")
    public List<Country> getAllCountries() {
        return countryApplicationService.getCountries();
    }
}
