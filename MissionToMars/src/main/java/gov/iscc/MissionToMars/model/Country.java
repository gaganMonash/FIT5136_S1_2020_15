package gov.iscc.MissionToMars.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Getter
@Setter
@Document (collection = "Countries")
public class Country {
    @Id
    int countryId;
    String countryName;
}
