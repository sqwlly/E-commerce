package log.test;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

import com.mongodb.MongoClient;
import log.model.Log;
import log.mongo.MongoDBUtil;
import main.java.log.util.ConvertUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MongoDBTest {

    private MongoClient mongoClient;

    @Before
    public void initMongoClient() throws IOException{
        mongoClient = MongoDBUtil.initMongo();
    }

    @Test(timeout = 1000)
    public void saveLogTest() throws IllegalArgumentException,
            IllegalAccessException{
        mongoClient.getDatabase("LogTest").getCollection("log")
                .insertOne(ConvertUtil.convertDoc(this.initLog()));
    }

    @After
    public void closeMongoClient(){
        mongoClient.close();
    }

    private Log initLog() {
        Exception e = new NullPointerException("------Test------");
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));
        Log log = new Log();
        log.setCreatedTime(new Date());
        log.setLevel("ERROR");
        log.setMessage(e.getMessage());
        log.setStackTrace(sw.getBuffer().toString());
        return log;
    }

}
