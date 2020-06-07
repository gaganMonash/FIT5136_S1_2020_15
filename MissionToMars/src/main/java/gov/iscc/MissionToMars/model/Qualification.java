package gov.iscc.MissionToMars.model;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "Qualification")
public class Qualification {
    @Id
    int qualificationId;
    String qualificationName;

}
