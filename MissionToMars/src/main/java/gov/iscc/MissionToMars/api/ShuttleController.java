package gov.iscc.MissionToMars.api;

import gov.iscc.MissionToMars.model.Mission;
import gov.iscc.MissionToMars.model.Shuttle;
import gov.iscc.MissionToMars.service.ShuttleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ Author : Tarun Verma
 * Shuttle Rest Controller
 */

@RestController
public class ShuttleController  {
    @Autowired
    ShuttleService shuttleService;

@GetMapping("/getShuttles")
    public List<Shuttle> getShuttles()
    {
    return shuttleService.findAllShuttles();
    }
    @GetMapping("/getShuttle")
    public Shuttle missionDetails(@RequestParam Integer id)
    {

        return   shuttleService.findById(id);

    }

}
