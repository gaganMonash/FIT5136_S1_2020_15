package gov.iscc.MissionToMars.api;

import gov.iscc.MissionToMars.model.Mission;
import gov.iscc.MissionToMars.service.MissionService;
import gov.iscc.MissionToMars.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
*Service for editing a existing mission.
*/


    @PostMapping("/editMission")
    public void editMission(@RequestBody Mission mission) {
        missionService.updateMission(mission);
    }

}
