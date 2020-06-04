package gov.iscc.MissionToMars.dao;
/**
 * @Authour : Saral Khandelwal
 * Declaration of interface for Mission Repository
 */

import gov.iscc.MissionToMars.model.Mission;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface MissionRepo extends MongoRepository<Mission, String> {

    @Override
    Optional<Mission> findById(String s);

    @Override
    Iterable<Mission> findAllById(Iterable<String> strings);


    Optional<Mission> findBy_idEquals(String s);

    Optional<Mission> findByKey(String key);


}
