package gov.iscc.MissionToMars.dao;

import gov.iscc.MissionToMars.model.Country;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CountryRepo extends MongoRepository<Country, Integer> {

    @Override
    Optional<Country> findById(Integer integer);

}

