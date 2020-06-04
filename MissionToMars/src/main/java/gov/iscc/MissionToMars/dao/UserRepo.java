package gov.iscc.MissionToMars.dao;
/**
 * @Authour : Gagan Ahuja
 * User Repo connects to Mongo Collection User
 */

import gov.iscc.MissionToMars.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface UserRepo extends MongoRepository<User, Integer> {

    /**
     * @param userLoginId user unique loginId
     * @param password    password of the user
     * @return User Object
     */
    public User findByUserLoginIdAndPassword(String userLoginId, String password);

    /**
     * @param userLoginId user unique loginId
     * @return User Object
     */
    public User findByUserLoginId(String userLoginId);

    /**
     * @param level user Level { Admin,Candidate,}
     * @return a all the users with input Level
     */
    public List<User> findAllByUserLevel(String level);




}
