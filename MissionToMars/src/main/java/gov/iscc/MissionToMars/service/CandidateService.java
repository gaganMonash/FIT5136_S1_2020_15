package gov.iscc.MissionToMars.service;
/**
 * @ Authour: Gagan Ahuja
 * Candidate Mongo Repository
 */

import gov.iscc.MissionToMars.dao.CandidateRepo;
import gov.iscc.MissionToMars.model.Candidate;
import gov.iscc.MissionToMars.model.SelectionCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService {
    @Autowired
CandidateRepo candidateRepo;

    /**
     * This method accepts the input selection criteria and fetches all candidates asper the input provided
     * @param sc - health record, age and qualification
     * @return List of Candidates
     */
    public List<Candidate> findNBestCandidates(SelectionCriteria sc) {
        // casting age range to specific start and end
        int ageStart=0;
        int ageEnd=0;
        String qualification="";
        String record="";

        String age=sc.getAge();
         qualification= sc.getQualification();
         record= sc.getHealthRecord();
        System.out.println(age);
        System.out.println(qualification);

        if(age!=null && age.equals("18-25"))
        {
            ageStart=18;
            ageEnd=25;
        }
        else if(age!=null && age.equals("25-31"))
        {
            ageStart=26;
            ageEnd=31;
        }
        else if(age!=null && age.equals("31-Above"))
        {
            ageStart=32;
            ageEnd=100;
        }
        System.out.println(ageStart+"-"+ageEnd+"-"+qualification+"-"+record);

if(ageStart==0 && qualification==null  && record!=null )
{
    return candidateRepo.findByHealthRecord(record);

}
else if((ageStart!=0 && qualification==null  && record==null )){
    return candidateRepo.findByAgeBetween(ageStart,ageEnd);
}
else if((ageStart==0 && qualification!=null  && record==null )){
    return candidateRepo.findByQualification(qualification);
}
else if((ageStart==0 && qualification!=null && record!=null)){
    return candidateRepo.findByQualificationAndHealthRecord(qualification,record);
}
else if((ageStart!=0 && qualification!=null  && record==null )){
    return candidateRepo.findByQualificationAndAgeBetween(qualification,ageStart,ageEnd);
}
else if((ageStart!=0 && qualification==null  && record!=null )){
    return candidateRepo.findByAgeBetweenAndHealthRecord(ageStart,ageEnd,record);
}
else
    return candidateRepo.findByQualificationAndAgeBetweenAndHealthRecord(qualification,ageStart,ageEnd,sc.getHealthRecord());

    }

}
