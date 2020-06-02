package gov.iscc.MissionToMars.util;


import java.io.File;
import java.util.*;

public class InsertUsers {

    List<String> headings = new LinkedList<String>() {
        {
            add("userId");
            add("userName");
            add("userLevel");

        }
    };



    public Map<String, Object> readDoc(String line) {

        Map<String, Object> map = new HashMap<>();
        String[] fieldVal = line.split(",");
        for (int i = 0; i < fieldVal.length; i++) {
           if(i==0)
           {map.put("_id",Integer.parseInt(fieldVal[i]));}
            if(i==1)
            {map.put("userName",fieldVal[i]);
             map.put("userLoginId",fieldVal[i].trim().replace(" ",".").toLowerCase());
            }
            if(i==2)
            {
                map.put("userLevel",fieldVal[i]);
            }

        }
        map.put("password",randomPasswordGenerator(7));
        return map;
    }


    public void insertData() {

        MongoUtil mongo = new MongoUtil( "MissionToMars","Users", 27017);
        int count=0;
        try {
            List<Map<String, Object>> data = new ArrayList<>();
            Map<String, Object> map = new HashMap<>();
            Scanner scanner = new Scanner(new File("src/main/resources/sampleData/EmployeeData.csv"));
            while (scanner.hasNextLine()) {
                if(count!=0) {
                    System.out.println("here");
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
    public String randomPasswordGenerator(int length)
    {
        String password="";
        Random rand = new Random();
        for (int i = 0; i <length ; i++) {
            int x= rand.nextInt(57)+65;
            if(x>=91 && x<=96)
                x=64;
            char c = (char)x;
            password+=Character.toString(c);
        }
        System.out.println(password);
        return password;
    }
    public static void main(String[] args) {
        new InsertUsers().insertData();

    }



}
