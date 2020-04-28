package log.test;
import java.io.IOException;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import log.mongo.MongoDBUtil;
import org.bson.Document;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MongoDBTest2 {

    private MongoClient mongoClient;

    @Before
    public void initMongoClient() throws IOException{
        mongoClient = MongoDBUtil.initMongo();
    }

    @Test(timeout = 1000)
    public void queryLogTest(){

        FindIterable<Document> iter =
                mongoClient.getDatabase("LogTest").getCollection("log").find();
        iter.forEach(new Block<Document>() {
            @Override
            public void apply(Document document) {
                System.out.println(document.toJson());
            }
        });
    }

    @After
    public void closeMongoClient(){
        mongoClient.close();
    }

}
