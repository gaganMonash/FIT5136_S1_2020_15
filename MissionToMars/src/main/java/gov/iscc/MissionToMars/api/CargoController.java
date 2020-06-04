package gov.iscc.MissionToMars.api;
/**
 * @Authour : Saral Khandelwal
 * Methods related to Cargo API
 */

import gov.iscc.MissionToMars.model.Cargo;
import gov.iscc.MissionToMars.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Method to get Cargo details present in Mongo DB using getCargo Rest API
 */
@RestController
public class CargoController {
    @Autowired
    CargoService cargoService;

    @GetMapping("/getCargo")
    public List<Cargo> getCargoList() {
        return cargoService.getCargo();
    }

}
