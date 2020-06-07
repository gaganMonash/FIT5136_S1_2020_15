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
    int travel_speed;
    int cargo_capacity;
    String country_origin;
    int fuel_capacity;
    String name;
    String manufacture_year;
    String origin;

}
