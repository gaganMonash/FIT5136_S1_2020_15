package gov.iscc.MissionToMars.dao;

import gov.iscc.MissionToMars.model.Mission;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface MissionRepo extends MongoRepository<Mission, String> {
    /**
     *
     * @param s mission id
     * @return Mission
     */
    @Override
    Optional<Mission> findById(String s);

    /**
     *
     * @param strings list of mission id
     * @return List of Mission
     */
    @Override
    Iterable<Mission> findAllById(Iterable<String> strings);

    /**
     *
     * @param s
     * @return
     */

    Optional<Mission> findBy_idEquals(String s);

    /**
     *
     * @param key
     * @return Mission
     */
    Optional<Mission> findByKey(String key);

    /**
     * Delet Mission from DB
     * @param key missionKey
     */
    public void deleteByKey(String key);


}
