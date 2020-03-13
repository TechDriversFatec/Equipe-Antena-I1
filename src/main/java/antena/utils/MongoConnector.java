package antena.utils;

import com.github.fakemongo.Fongo;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoConnector {

    public static MongoDatabase connectToMongo(String ip, String collection){
        return new MongoClient(ip).getDatabase(collection);
    }

    public static MongoClient getClient(String ip){
        if (ip.equals("fongo")){
            return new Fongo("test").getMongo();
        }
        return new MongoClient(ip);
    }
}
