package gov.iscc.MissionToMars.model;
/**
 * @Authour : Saral Khandelwal
 * Declaration of Cargo class along with its private attributes which will be saved in Mongo DB
 */

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter

@Document(collection = "Cargo")
public class Cargo {

    String cargoName;
    int cargoQuantity;
}
