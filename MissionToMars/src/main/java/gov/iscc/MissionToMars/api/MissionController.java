package gov.iscc.MissionToMars.api;
/**
 *@Authour : Saral Khandelwal
 * Methods related to Mission API
 */

import gov.iscc.MissionToMars.model.Mission;
import gov.iscc.MissionToMars.service.MissionService;
import gov.iscc.MissionToMars.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Method to add Mission details in Mongo DB using addMission Rest API
 */
@RestController
public class MissionController {

    @Autowired
    MissionService missionService;
    @Autowired
    UserService userService;
    @PostMapping("/addMission")
    public void addMission(@RequestBody Mission mission)
    {
        ObjectId id = new ObjectId();
        try {


            mission.set_id(id.toString());
            mission.setKey(id.toString());
           userService.updateMissionList(mission.getCoordinatorId(),id.toString());
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        List<Integer> administrators = mission.getAdministrators();
        if(administrators!=null) {
            for (int admin :
                    administrators) {
                userService.updateMissionList(admin, id.toString());

            }
        }
        missionService.addMission(mission);

    }

/**
 * Method to get Mission details from Mongo DB using getMission Rest API
 */
@GetMapping("/getMissions")
    public List<Mission>getMissions()
    {
        return missionService.getMissions();
    }
    @GetMapping("/getMissionDetails")
    public Mission missionDetails(@RequestParam String id)
    {
        System.out.println(id);
      return   missionService.getMissions(id);

    }

/**
 * Method to edit Mission details in Mongo DB using editMission Rest API
 */
    @PostMapping("/editMission")
    public void editMission(@RequestBody Mission mission) {
        missionService.updateMission(mission);
    }

}
