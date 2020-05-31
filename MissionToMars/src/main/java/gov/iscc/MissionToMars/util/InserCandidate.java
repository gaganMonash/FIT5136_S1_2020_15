package gov.iscc.MissionToMars.util;

import java.io.File;
import java.util.*;

public class InserCandidate {

    public void insertData() {

        MongoUtil mongo = new MongoUtil( "MissionToMars","Candidate", 27017);

        try {
            List<Map<String, Object>> data = new ArrayList<>();
            Map<String, Object> map = new HashMap<>();
            Scanner scanner = new Scanner(new File("src/main/resources/sampleData/Candidate.csv"));
            while (scanner.hasNextLine()) {

                String line=scanner.nextLine();
                String[] values = line.split(",");
                int count=0;
                for (int i = 0; i < values.length; i++) {
                    System.out.println(values[i].toString());
                    if(count==0) {
                        try {
                            map.put("_id", Integer.parseInt(values[i]));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if(count==1)
                    {
                        map.put("name",values[i]);

                    }
                    if(count==2)
                    {
                        try {
                            int age = Integer.parseInt(values[i]);
                            map.put("age", age);
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                        }

                    }
                    if(count==3)
                    {
                        map.put("street",(values[i]));

                    }
                    if(count==4)
                    {
                        map.put("city",(values[i]));

                    }
                    if(count==5)
                    {
                        map.put("postal",(values[i]));

                    }
                    if(count==6)
                    {
                        map.put("country",(values[i]));

                    }
                    if(count==7)
                    {
                        map.put("phone",(values[i]));

                    }
                    if(count==8)
                    {
//                        System.out.println(count);
//                        System.out.println(values[i]);
                        map.put("idType",values[i]);

                    }
                    if(count==9)
                    {
                        map.put("gender",(values[i]));

                    }
                    if(count==10)
                    {
                        map.put("allergies",(values[i]));

                    }
                    if(count==11)
                    {
                        map.put("foodpref",(values[i]));

                    }
                    if(count==12)
                    {
                        //= new ArrayList<>();
                        String[] pieces = values[i].split("\\|");
                        for(int j=0;j<pieces.length;j++)
                        {
                            //System.out.println(pieces[j]);
                            //list.add(pieces[j]);
                        }
                        List<String> list = Arrays.asList(pieces);
                        map.put("Qualification",list);

                    }
                    if(count==13)
                    {
                        System.out.println(values[i]);
                        map.put("workex",(values[i]));

                    }
                    if(count==14)
                    {
                        String[] pieces = values[i].split("\\|");
                        List<String> list = Arrays.asList(pieces);
                        map.put("occupation",list);

                    }
                    if(count==15)
                    {
                        map.put("computerskill",(values[i]));

                    }
                    if(count==16)
                    {
                        String[] pieces = values[i].split("\\|");
                        List<String> list = Arrays.asList(pieces);
                        map.put("languageknown",list);

                    }
                    if(count==17)
                    {
                        map.put("healthRecord",(values[i]));

                    }
                    if(count==18)
                    {
                        map.put("criminalRecord",(values[i]));

                    }

                    count++;

                }

                data.add(map);
                map = new HashMap<>();

            }
            mongo.addMultipleDocuments(data);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new InserCandidate().insertData();

    }
}
