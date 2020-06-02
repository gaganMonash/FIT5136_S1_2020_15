package gov.iscc.MissionToMars.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document(collection = "Candidate")
public class Candidate {
    @Id
    int _id;
    int age;
    String street;
    String city;
    String postal;
    String country;
    String phone;
    String idType;
    String gender;
    List<String> allergies;
    String foodPreferences;
    List<String> qualification;
    String workex;
    List<String> occupations;
    String computerSkill;
    List<String> languagesKnown;
    String criminalRecord;
    String healthRecord;


}
