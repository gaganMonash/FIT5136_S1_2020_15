package gov.iscc.MissionToMars.dao;

import gov.iscc.MissionToMars.model.Qualification;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QualificationRepo extends MongoRepository<Qualification,Integer> {
}
