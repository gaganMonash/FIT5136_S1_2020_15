package gov.iscc.MissionToMars.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@ToString
@Getter
@Setter
@Document(collection = "Cargo")
public class Cargo {
    @Id
    int _id;
String cargoName;
int cargoQuantity;
}
