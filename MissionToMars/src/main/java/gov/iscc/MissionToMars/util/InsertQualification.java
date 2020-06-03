package gov.iscc.MissionToMars.util;

import java.io.File;
import java.util.*;

public class InsertQualification {

    public void insertData() {

        MongoUtil mongo = new MongoUtil( "MissionToMars","Qualification", 27017);
        int count=1;
        try {
            List<Map<String, Object>> data = new ArrayList<>();
            Map<String, Object> map = new HashMap<>();
            Scanner scanner = new Scanner(new File("src/main/resources/sampleData/qualification.csv"));
            while (scanner.hasNextLine()) {
                map.put("qualificationName",scanner.nextLine());
                map.put("_id",count);
                count++;
                data.add(map);
                map = new HashMap<>();

            }
            mongo.addMultipleDocuments(data);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new InsertQualification().insertData();

    }
}
