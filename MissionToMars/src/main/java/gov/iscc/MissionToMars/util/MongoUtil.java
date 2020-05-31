package gov.iscc.MissionToMars.util;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MongoUtil {
    private final String mongoDBName;
    private final String mongoCollectionName;
    private final int mongoPort;
    private final String host_name = "localhost";

    public MongoUtil(String mongoDBName, String mongoCollectionName, int mongoPort) {
        this.mongoDBName = mongoDBName;
        this.mongoCollectionName = mongoCollectionName;
        this.mongoPort = mongoPort;
    }

    // Fetching all documents from the mongo collection.
    private static void getAllDocuments(MongoCollection<Document> col) {


        // Performing a read operation on the collection.
        FindIterable<Document> fi = col.find();
        MongoCursor<Document> cursor = fi.iterator();

    }

    @SuppressWarnings("resource")
    public static void main(String[] args) throws FileNotFoundException {

        MongoUtil mongo = new MongoUtil("MissionToMars", "Users", 27017);

        mongo.findDoc(4000, new ObjectId().toString());
    }

    public void addMultipleDocuments(List<Map<String, Object>> data) {


        // Mongodb connection string.
        String client_url = "mongodb://" + host_name + ":" + mongoPort + "/" + mongoDBName;
        MongoClientURI uri = new MongoClientURI(client_url);

        // Connecting to the mongodb server using the given client uri.
        MongoClient mongo_client = new MongoClient(uri);

        // Fetching the database from the mongodb.
        MongoDatabase db = mongo_client.getDatabase(mongoDBName);

        // Fetching the collection from the mongodb.
        MongoCollection<Document> coll = db.getCollection(mongoCollectionName);

        List<Document> docs = new ArrayList<Document>();
        for (Map<String, Object> doc : data) {
            Document dc = new Document();
            System.out.println(doc);
            System.out.println("-----");
            dc.putAll(doc);

            docs.add(new Document(dc));
        }

        MongoCollection<Document> col = db.getCollection(mongoCollectionName);
        col.insertMany(docs);
    }

    public void findDoc(int id, String missionId) {
        String client_url = "mongodb://" + host_name + ":" + mongoPort + "/" + mongoDBName;
        MongoClientURI uri = new MongoClientURI(client_url);

        MongoClient mongo_client = new MongoClient(uri);


        MongoDatabase db = mongo_client.getDatabase(mongoDBName);


        MongoCollection<Document> coll = db.getCollection(mongoCollectionName);

        List<Document> docs = new ArrayList<Document>();
        BasicDBObject query = new BasicDBObject();
        query.put("_id", id);

        MongoCollection<Document> col = db.getCollection(mongoCollectionName);


        Document d = col.findOneAndDelete(query);
        List<Object> missionIds = null;
        try {
            missionIds = (List<Object>) d.get("missions");
        } catch (Exception e) {
        }
        if (missionIds == null) {
            missionIds = new ArrayList<>();
            missionIds.add(missionId);
        } else {
            missionIds.add(missionId);
        }
        d.put("missions", missionIds);

        System.out.println(d);
        col.insertOne(d);
        mongo_client.close();


    }
}
