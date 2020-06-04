package gov.iscc.MissionToMars.dao;
/**
 * @Authour : Saral Khandelwal
 * Declaration of interface for Cargo Repository
 */

import gov.iscc.MissionToMars.model.Cargo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CargoRepo extends MongoRepository<Cargo, Integer> {


}
