package gov.iscc.MissionToMars.service;

import gov.iscc.MissionToMars.dao.ShuttleRepo;
import gov.iscc.MissionToMars.model.Shuttle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ Author : Tarun Verma
 * Shuttle Services
 */
@Service
public class ShuttleService {
    @Autowired
    ShuttleRepo shuttleRepo;

    /** Finding all the shuttles in the database
     *
     * @return List of Shuttles
     */
    public List<Shuttle> findAllShuttles()
    {
        return shuttleRepo.findAll();
    }

    /**
     * Find a specific shuttle using id
     * @param Integer shuttle Id
     * @return shuttle
     */
    public Shuttle findById(int Integer)
    {return shuttleRepo.findBy_idEquals(Integer);}



}
