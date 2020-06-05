package gov.iscc.MissionToMars.dao;

/**
 * @ Authour: Gagan Ahuja
 * Candidate Mongo Repository
 */

import gov.iscc.MissionToMars.model.Candidate;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface CandidateRepo  extends MongoRepository<Candidate,Integer> {
    /**
     * Find Candidates By Heath Record provided
     * @param record  health status {FIT,Unfit}
     * @return  List of Candidate
     */
    List<Candidate> findByHealthRecord(String record);

    /**
     *Find Candidates By Age between start and end
     * @param start Integer start range of age
     * @param end Integer end range of age
     * @return List of Candidate
     */
    List<Candidate> findByAgeBetween(int start, int end);

    /**
     *Find Candidates By qualification
     * @param qualification Degree{BE,ME}
     * @return List of Candidate
     */
    List<Candidate> findByQualification(String qualification);

    /**
     *Find Candidates  By Age between start and end qualification
     * @param qualification Degree{BE,ME}
     * @param start Integer start range of age
     * @param end Integer end range of age
     * @return List of Candidate
     */
    List<Candidate> findByQualificationAndAgeBetween(String qualification, int start, int end);

    /**
     *Find Candidates By Heath Record provided
     * @param qualification Degree{BE,ME}
     * @param record health status {FIT,Unfit}
     * @return List of Candidate
     */
    List<Candidate> findByQualificationAndHealthRecord(String qualification,String record);

    /**
     *Find Candidates By Heath Record provided and By Age between start and end
     * @param start -Integer start range of age
     * @param end- Integer end range of age
     * @param record  health status {FIT,Unfit}
     * @return List of Candidate
     */
    List<Candidate> findByAgeBetweenAndHealthRecord(int start, int end,String record);

    /**
     * Find Candidates By Heath Record provided
     * @param qualification Degree{BE,ME}
     * @param start Integer start range of age
     * @param end Integer end range of age
     * @param rec health status {FIT,Unfit}
     * @return List of Candidate
     */
    List<Candidate> findByQualificationAndAgeBetweenAndHealthRecord(String qualification,int start,int end,String rec);






}
