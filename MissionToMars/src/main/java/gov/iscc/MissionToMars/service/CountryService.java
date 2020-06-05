package gov.iscc.MissionToMars.service;

import gov.iscc.MissionToMars.dao.CountryRepo;
import gov.iscc.MissionToMars.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {
    @Autowired
CountryRepo countryRepo;

public List<Country> getAllCountry()
{return  countryRepo.findAll();}

public Optional<Country> getCountryName(Country c)
{return countryRepo.findById(c.getCountryId());}

}
