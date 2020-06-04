package gov.iscc.MissionToMars.service;
/**
 * @Authour : Saral Khandelwal
 * Class related to Cargo Service
 */

import gov.iscc.MissionToMars.dao.CargoRepo;
import gov.iscc.MissionToMars.model.Candidate;
import gov.iscc.MissionToMars.model.Cargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoService {
    @Autowired
    CargoRepo cargoRepo;

    /**
     * Method to get all Cargo from Database through service call
     */
    public List<Cargo> getCargo() {
        return cargoRepo.findAll();
    }
}
