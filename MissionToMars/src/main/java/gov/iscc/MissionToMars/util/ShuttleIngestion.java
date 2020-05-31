package gov.iscc.MissionToMars.util;

import java.io.File;
import java.util.*;

public class ShuttleIngestion  {


    List<String> headings = new LinkedList<String>() {
        {
            add("_id");
            add("name");
            add("manufacture_year");
            add("fuel_capacity");
            add("cargo_capacity");
            add("travel_speed");
            add("origin");
            add("country_origin");
            add("shuttle_id");


        }
    };


    public Map<String, Object> readDoc(String line) {
        Map<String, Object> schema = new LinkedHashMap<>();
        schema.put("_id", "Integer");
        schema.put("name", "String");
        schema.put("manufacture_year", "Date");
        schema.put("fuel_capacity", "Integer");
        schema.put("passenger_capacity", "Integer");
        schema.put("cargo_capacity", "Integer");
        schema.put("travel_speed", "Double");
        schema.put("origin", "String");
        schema.put("country_origin", "String");
        schema.put("shuttle_id", "Integer");

        Map<String, Object> map = new HashMap<>();
        String[] fieldVal = line.split(",");
        for (int i = 0; i < fieldVal.length; i++) {
            String label = headings.get(i);
            String type = schema.get(label).toString();
            Object finalVal = castVal(fieldVal[i], type);
            map.put(label, finalVal);

        }
        return map;
    }


    public void insertData() {
        MongoUtil mongo = new MongoUtil("MissionToMars","Shuttles", 27017);
        int count=0;
        try {
            List<Map<String, Object>> data = new ArrayList<>();
            Map<String, Object> map = new HashMap<>();
            Scanner scanner = new Scanner(new File("src/main/resources/sampleData/shuttle.csv"));
            while (scanner.hasNextLine()) {
                if(count!=0) {
                    //System.out.println("here");
                    map = readDoc(scanner.nextLine());
                    data.add(map);
                    map = new HashMap<>();
                }else{
                    count++;
                scanner.nextLine();
                }
            }
            mongo.addMultipleDocuments(data);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public Object castVal(String val, String type)
    {

        if(type.equals("Integer"))
        {
            return Integer.parseInt(val);
        }
        if(type.equals("Double"))
        {
            return Double.parseDouble(val);
        }
        return val;
    }
    public static void main(String[] args) {
        new ShuttleIngestion().insertData();
    }
}
