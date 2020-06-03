package gov.iscc.MissionToMars.api;

import gov.iscc.MissionToMars.model.User;
import gov.iscc.MissionToMars.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController

public class UserController {
    @Autowired
    UserService userService;


    @PostMapping("/authenticate")
    public User login(@RequestBody User u) {
        System.out.println("In authentication contr.");
        System.out.println(u.getUserLoginId());
        System.out.println(u.getPassword());
        return userService.authenticate(u.getUserLoginId(), u.getPassword());
    }


    @GetMapping("/getAdmins")
    public List<User> getAllAdmins(@RequestParam String level) {
        return userService.getAllUsers(level);
    }

}
