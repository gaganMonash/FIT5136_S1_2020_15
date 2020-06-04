package gov.iscc.MissionToMars.service;
/**
 * @Authour : GAGAN AHUJA
 *  User Service
 */

import gov.iscc.MissionToMars.dao.UserRepo;
import gov.iscc.MissionToMars.model.Mission;
import gov.iscc.MissionToMars.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    MissionService missionService;

    /**
     * This method returns all those users with the input type user level.
     *
     * @param level user level{Adminisrtrator,Coordinator,Candidate}
     * @return List of User of the provided Level
     */
    public List<User> getAllUsers(String level) {
        return userRepo.findAllByUserLevel(level);
    }

    /**
     * This methos finds all Missions of the following User
     *
     * @param userLoginId user unique loginId
     * @return
     */
    public List<HashMap<String, Object>> getUserMissions(String userLoginId) {
        System.out.println("In get user details");
        User u = userRepo.findByUserLoginId(userLoginId);
        List<String> missionIds = u.getMissions();
        List<Mission> missions = missionService.getMissions(missionIds);
        List<HashMap<String, Object>> listOfMission = new ArrayList<>();
        for (Mission m : missions) {
            HashMap<String, Object> missionMap = new HashMap<>();
            missionMap.put("name", m.getName());
            missionMap.put("id", m.get_id().toString());
            missionMap.put("status", m.getStatus());
            missionMap.put("description", m.getDescription());
            listOfMission.add(missionMap);

        }
        HashMap<String, Object> outputMap = new HashMap<>();

        return listOfMission;
    }

    /**
     * Authenticating user with the following credentials
     *
     * @param userLoginId user unique loginId
     * @param passsword   password of user
     * @return User Object
     */
    public User authenticate(String userLoginId, String passsword) {
        System.out.println("In authentication");
        User user = userRepo.findByUserLoginIdAndPassword(userLoginId, passsword);
        if (user == null) {
            user = new User();
            user.setUserLevel("InValid");
        }
        return user;
    }

    /**
     * This method adds a new missionId to the users mission ids
     *
     * @param userId    user unique loginId
     * @param missionId mission identifier
     */
    public void updateMissionList(int userId, String missionId) {
        System.out.println("updateMissionList");
        Optional<User> u = userRepo.findById(userId);
        User oldUser = u.orElse(new User());
        System.out.println(oldUser.getUserName());
        List<String> ids = oldUser.getMissions();
        if (ids == null) {
            ids = new ArrayList<>();
            ids.add(missionId);

        } else {
            ids.add(missionId);
        }
        oldUser.setMissions(ids);

        userRepo.save(oldUser);
    }
}
