package gov.iscc.MissionToMars.service;
/**
 * @Authour : Saral Khandelwal
 * Class for mission service
 */

import com.fasterxml.jackson.databind.util.ArrayIterator;
import gov.iscc.MissionToMars.dao.MissionRepo;
import gov.iscc.MissionToMars.model.Mission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MissionService {
    @Autowired
    MissionRepo missionRepo;

    /**
     * Method to add Mission to Database through service call
     */
    public void addMission(Mission mission) {
        missionRepo.insert(mission);
    }

    /**
     * Method to get Mission from Database through service call
     */
    public List<Mission> getMissions() {
        return missionRepo.findAll();
    }

    /**
     * Method to get list of Mission from Database corresponding to its id through service call
     */
    public List<Mission> getMissions(List<String> ids) {
        List<Mission> missions = new ArrayList<>();
        for (String missionId :
                ids) {
            missions.add(missionRepo.findByKey(missionId).orElse(new Mission()));

        }
        return missions;
    }

    /**
     * Method to get a Mission from Database through service call
     */
    public Mission getMissions(String missionId) {
        return missionRepo.findByKey(missionId).orElse(new Mission());
    }

    /**
     * Method to update a Mission to Database through service call
     */
    public void updateMission(Mission mission) {
        missionRepo.save(mission);
    }

}
