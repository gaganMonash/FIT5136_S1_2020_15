package gov.iscc.MissionToMars.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document(collection = "Missions")
public class Mission {
    @Id
    private String _id;
    private String name;
    private String description;
    private String origin;
    private List<String> countriesAllowed;
    private int coordinatorId;
    //  private List<Job>jobs;
    private List<Requirement> employmentRequirements;
    private String launchDate;
    private List<String> qualification;
    private String status;
    private String duration;
    private List<Integer> administrators;
    // private List<Shuttle>shuttles;
    private List<Cargo> cargo;
    private List<String> languageRequired;
    private String key;

}
