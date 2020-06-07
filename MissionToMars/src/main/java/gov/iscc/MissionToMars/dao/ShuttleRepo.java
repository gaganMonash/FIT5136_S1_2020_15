package gov.iscc.MissionToMars.dao;

import gov.iscc.MissionToMars.model.Shuttle;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @ Author : Tarun Verma
 * Shuttle Mongo repo
 */

public interface ShuttleRepo extends MongoRepository<Shuttle,Integer> {

    /**
     * using shuttle id
     * @param integer shuttleId
     * @return shuttle
     *
     */
    public Shuttle findBy_idEquals(int integer);

    /**
     *   Find all Shuttles
     * @return List of Shuttle
     */
    public List<Shuttle> findAll();
}
