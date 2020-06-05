package gov.iscc.MissionToMars.api;

import gov.iscc.MissionToMars.model.Qualification;
import gov.iscc.MissionToMars.service.QualificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QualificationController {
    @Autowired
    QualificationService qualificationService;
    @GetMapping("/getQualifications")
    public List<Qualification> getAllQualifications()
    {
        return qualificationService.getAllQualifications();
    }


}
