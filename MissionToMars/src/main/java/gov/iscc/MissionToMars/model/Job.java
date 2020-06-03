package gov.iscc.MissionToMars.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Getter
@Setter


public class Job {
    String jobName;
    String jobDescription;

}
