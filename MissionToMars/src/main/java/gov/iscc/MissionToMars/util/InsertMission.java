package gov.iscc.MissionToMars.util;

/**
 * @Authour : Gagan Ahuja
 * Inserting Missions in Mongo DB
 */

import org.bson.types.ObjectId;

import java.io.File;
import java.util.*;

public class InsertMission {

    public static void main(String[] args) {
        new InsertMission().insertData();
    }

    /**
     * Read from file mission.csv and inserts in Mongo Collection Mission
     */
    public void insertData() {
        String[] headings = {"name", "launchDate", "origin", "duration", "type", "description", "employmentRequirements", "age", "minimumYearsOfExperience", "qualification", "occupations", "languageRequired", "cargoFor", "cargoRequired", "quantityRequired", "countriesAllowed"};
        String[] status = {"Completed", "Failed", "Aborted", "Planning", "Departed", "Returned"};
        Random r = new Random();
        MongoUtil mongo = new MongoUtil("MissionToMars", "Missions", 27017);
        MongoUtil mongoUser = new MongoUtil("MissionToMars", "Users", 27017);
        int count = 1;

        try {
            List<Map<String, Object>> listOfMissions = new ArrayList<>();
            // reading file
            Scanner scanner = new Scanner(new File("src/main/resources/sampleData/mission.csv"));
            while (scanner.hasNextLine()) {
                //for notinserting headings
                if (count != 1) {
                    String line = scanner.nextLine();
                    Map<String, Object> document = new HashMap<>();
                    String[] values = line.split(",");
                    System.out.println(values.length);
                    for (int i = 0; i < values.length; i++) {
                        String cargoType = "For Mission";
                        String quantityRequired = "20";

                        if (headings[i] == "countriesAllowed") {
                            List<String> allowedCountries = new ArrayList<>();
                            String[] allowedCount = values[i].split("\\|");
                            for (String country : allowedCount) {
                                allowedCountries.add(country);

                            }
                            document.put(headings[i], allowedCountries);
                        } else if (headings[i] == "cargoType") {
                            cargoType = values[i];
                        } else if (headings[i] == "cargoRequired") {
                            List<Map<String, Object>> lstOfCargo = new ArrayList<>();
                            Map<String, Object> cargo = new HashMap<>();
                            String[] creq = values[i].split("\\|");
                            for (String carReq : creq) {
                                cargo.put("cargoType", cargoType);
                                cargo.put("cargoRequired", carReq);
                                cargo.put("quantityRequired", quantityRequired);
                                lstOfCargo.add(cargo);
                                cargo = new HashMap<>();
                            }

                            document.put("cargo", lstOfCargo);

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
                            document.put(headings[i], listLanguagesRequired);
                        } else if (headings[i] == "description") {
                            document.put(headings[i], values[i].replace("|", ","));
                        } else if (headings[i] == "qualification") {
                            List<String> listQualifications = new ArrayList<>();
                            String v = values[i];
                            if (v.endsWith("\\|")) {
                                v = v.substring(0, v.length() - 2);
                            }
                            String[] qualificationArray = v.split("\\|");
                            for (String qualification : qualificationArray) {
                                listQualifications.add(qualification);
                            }
                            document.put(headings[i], listQualifications);
                        } else if (headings[i] == "employmentRequirements") {
                            List<Map<String, Object>> lstOfEmploymenrRequirement = new ArrayList<>();
                            Map<String, Object> cargo = new HashMap<>();
                            String[] creq = values[i].split("\\|");
                            for (String carReq : creq) {
                                cargo.put("employmentType", carReq);
                                cargo.put("Number", r.nextInt(9));
                                lstOfEmploymenrRequirement.add(cargo);
                                cargo = new HashMap<>();
                            }

                            document.put(headings[i], lstOfEmploymenrRequirement);
                        } else if (headings[i] == "quantityRequired") {
                            quantityRequired = values[i];
                        } else {
                            document.put(headings[i], values[i]);
                        }

                    }
                    count++;
                    // Adding a random Coordinator to Mission
                    int cordinator = r.nextInt(100) + 4000;
                    document.put("coordinatorId", cordinator);
                    String id = new ObjectId().toString();
                    document.put("_id", id);
                    document.put("key", id);
                    // Maps Coordinator to this Mission
                    mongoUser.findDoc(cordinator, id);

                    // Adding Random Administrators to Mission
                    List<Integer> adminIds = new ArrayList<>();
                    for (int i = 0; i < 5; i++) {
                        int adminId = r.nextInt(58) + 1022;
                        if (adminId % 2 == 0) {
                            adminId += 1;
                        }
                        adminIds.add(adminId);
                        mongoUser.findDoc(adminId, id);
                    }
                    document.put("administrators", adminIds);
                    // Adding a random Status to Mission.
                    document.put("status", status[r.nextInt(5)]);
                    listOfMissions.add(document);
                    document = new HashMap<>();
                } else {
                    count = 2;
                }
            }
            // Adding all Missions to Mongo
            mongo.addMultipleDocuments(listOfMissions);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
