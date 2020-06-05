package gov.iscc.MissionToMars.service;

import gov.iscc.MissionToMars.dao.QualificationRepo;
import gov.iscc.MissionToMars.model.Qualification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Service
public class QualificationService {
@Autowired
    QualificationRepo qualificationRepo;

public List<Qualification> getAllQualifications()
{
 return qualificationRepo.findAll();
}

}
