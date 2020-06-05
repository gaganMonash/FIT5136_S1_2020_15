package gov.iscc.MissionToMars.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString

@Document(collection = "Shuttles")
public class Shuttle {

@Id
    int _id;
    int travelSpeed;
    int cargoCapacity;
    String countryOrigin;
    int fuelCapacity;
    String shuttleName;
    String manufactureYear;
    String origin;

}
