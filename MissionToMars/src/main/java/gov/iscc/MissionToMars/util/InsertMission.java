package gov.iscc.MissionToMars.util;

import gov.iscc.MissionToMars.model.Cargo;
import org.bson.types.ObjectId;

import java.io.File;
import java.util.*;

public class InsertMission {

    public void insertData() {
String[]headings={"name","launchDate","origin","duration",	"type"	,"description","employmentRequirements",	"age"	,"minimumYearsOfExperience",	"qualification"	,"occupations"	,"languageRequired","cargoFor",	"cargoRequired",	"quantityRequired",	"countriesAllowed"
};
        Random r = new Random();


        MongoUtil mongo = new MongoUtil( "MissionToMars","Missions", 27017);
        MongoUtil mongoUser = new MongoUtil( "MissionToMars","Users", 27017);

        int count=1;
        try {
            List<Map<String, Object>> data = new ArrayList<>();

            System.out.println(headings.length);
            Scanner scanner = new Scanner(new File("src/main/resources/sampleData/mission.csv"));
            while (scanner.hasNextLine()) {
                if(count!=1) {

                    String line = scanner.nextLine();
                    Map<String, Object> map = new HashMap<>();
                    String values[] = line.split(",");
                    System.out.println(values.length);
                    for (int i = 0; i < values.length; i++) {


                        String cargoType = "For Mission";
                        String quantityRequired = "20";

                        if (headings[i] == "countriesAllowed") {
                            List<String> allowedCountries = new ArrayList<>();
                            String allowedCount[] = values[i].split("\\|");
                            for (String country : allowedCount) {
                                allowedCountries.add(country);

                            }
                            map.put(headings[i], allowedCountries);
                        } else if (headings[i] == "cargoType") {
                            cargoType = values[i];
                        } else if (headings[i] == "cargoRequired") {
                            List<Map<String, Object>> lstOfCargo = new ArrayList<>();
                            Map<String, Object> cargo = new HashMap<>();
                            String creq[] = values[i].split("\\|");
                            for (String carReq : creq) {
                                cargo.put("cargoName", carReq);

                                cargo.put("cargoQuantity", Integer.parseInt(quantityRequired));
                                cargo.put("cargoType", cargoType);
                                lstOfCargo.add(cargo);
                                cargo = new HashMap<>();
                            }

                            map.put("cargo", lstOfCargo);

                        } else if (headings[i] == "languageRequired") {
                            List<String> listLanguagesRequired = new ArrayList<>();
                            String v = values[i];
                            if (v.endsWith("\\|")) {
                                v = v.substring(0, v.length() - 2);
                            }
                            String[] requiredLanguages = v.split("\\|");
                            for (String lang :
                                    requiredLanguages) {
                                listLanguagesRequired.add(lang);
                            }
                            map.put(headings[i], listLanguagesRequired);
                        } else if (headings[i] == "description") {
                            map.put(headings[i], values[i].replace("|", ","));
                        } else if (headings[i] == "qualification") {
                            List<String> listQualifications = new ArrayList<>();
                            String v = values[i];
                            if (v.endsWith("\\|")) {
                                v = v.substring(0, v.length() - 2);
                            }
                            String[] qual = v.split("\\|");
                            for (String q :
                                    qual) {
                                listQualifications.add(q);
                            }
                            map.put(headings[i], listQualifications);
                        } else if (headings[i] == "employmentRequirements") {
                            List<Map<String, Object>> lstOfEmploymenrRequirement = new ArrayList<>();
                            Map<String, Object> cargo = new HashMap<>();
                            String creq[] = values[i].split("\\|");
                            for (String carReq : creq) {
                                cargo.put("employmentType", carReq);
                                cargo.put("Number", r.nextInt(9));
                                lstOfEmploymenrRequirement.add(cargo);
                                cargo = new HashMap<>();
                            }

                            map.put(headings[i], lstOfEmploymenrRequirement);
                        } else if (headings[i] == "quantityRequired") {
                            quantityRequired = values[i];
                        } else {
                            map.put(headings[i], values[i]);
                        }

                    }
                    count++;
                    int cordinator = r.nextInt(100) + 4000;
                    map.put("coordinatorId", cordinator);
                    String id = new ObjectId().toString();
                    map.put("_id", id);
                    map.put("key", id);
                    mongoUser.findDoc(cordinator, id);
                    List<Integer> adminIds = new ArrayList<>();
                    for (int i = 0; i < 5; i++) {
                        int adminId = r.nextInt(58) + 1022;
                        if (adminId % 2 == 0) {
                            adminId += 1;
                        }
                        adminIds.add(adminId);
                        mongoUser.findDoc(adminId, id);
                    }
                    map.put("administrators", adminIds);
                    String status[]={"Completed","Failed","Aborted","Planning","Departed","Returned"};
                    map.put("status",status[r.nextInt(5)]);
                    data.add(map);
                    map = new HashMap<>();
                }
                else{count=2;}
            }
            mongo.addMultipleDocuments(data);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
new InsertMission().insertData();
    }
}
