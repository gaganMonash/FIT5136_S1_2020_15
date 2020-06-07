package gov.iscc.MissionToMars.api;

import gov.iscc.MissionToMars.model.Country;
import gov.iscc.MissionToMars.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class CountryController {
@Autowired
    CountryService countryService;
    @GetMapping("/getCountries")
   public List<Country> getAllCountries()
   {
       return  countryService.getAllCountry();
   }

   @PostMapping("/getCountry")
   public Optional<Country> getCountry(@RequestBody Country country)
   {return countryService.getCountryName(country);}
}
