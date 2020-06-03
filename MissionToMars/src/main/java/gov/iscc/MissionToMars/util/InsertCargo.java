package gov.iscc.MissionToMars.util;

import java.io.File;
import java.util.*;

public class InsertCargo {

    public void insertData() {

        MongoUtil mongo = new MongoUtil( "MissionToMars","Cargo", 27017);

        try {
            List<Map<String, Object>> data = new ArrayList<>();
            Map<String, Object> map = new HashMap<>();
            Scanner scanner = new Scanner(new File("src/main/resources/sampleData/Cargo.csv"));
            while (scanner.hasNextLine()) {

                String line=scanner.nextLine();
                String[] values = line.split(",");
                int count=0;
                for (int i = 0; i < values.length; i++) {
                        System.out.println(values[i].toString());

                        if (count == 0) {
                            try {
                                map.put("_id", Integer.parseInt(values[i]));
                            }catch(Exception e)
                            { map.put("_id", 123);}

                        }
                        if (count == 1) {
                            map.put("cargoName", values[i]);

                        }
                        if (count == 2) {
                            map.put("cargoQuantity", Integer.parseInt(values[i]));

                        }
                        count++;


                }

                if(!map.isEmpty())
                data.add(map);
                map = new HashMap<>();

            }
            mongo.addMultipleDocuments(data);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new InsertCargo().insertData();

    }
}
