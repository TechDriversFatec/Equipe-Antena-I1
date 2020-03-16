package antena.utils;

import com.github.fakemongo.Fongo;
import com.mongodb.MongoClient;
import com.mongodb.async.SingleResultCallback;
import com.mongodb.async.client.MongoClients;

import com.mongodb.async.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.concurrent.CountDownLatch;

public class MongoConnector {

    /*public static void iniciarConexao() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        com.mongodb.async.client.MongoClient mongoClient = MongoClients.create();
        com.mongodb.async.client.MongoDatabase database =  mongoClient.getDatabase("app");
        MongoCollection<Document> collection = database.getCollection("test");
        SingleResultCallback<Void> callbackWhenFinished = new SingleResultCallback<Void>() {
            @Override
            public void onResult(final Void result, final Throwable t) {
                System.out.println("Mongo Conectado!");
                latch.countDown();
            }
        };

        collection.insertOne(new Document("test", "test"),callbackWhenFinished);

        latch.await();
    }*/

    public static MongoDatabase connectToMongo(String ip, String collection){
        return getClient(ip).getDatabase(collection);
    }

    public static MongoClient getClient(String ip){
        if (ip.equals("fongo")){
            return new Fongo("test").getMongo();
        }
        return new MongoClient(ip);
    }
}
