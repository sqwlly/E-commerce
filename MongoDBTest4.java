package log.test;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

import com.mongodb.MongoClient;
import log.model.ClickLog;
import log.mongo.MongoDBUtil;
import main.java.log.util.ConvertUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MongoDBTest3 {

    private MongoClient mongoClient;

    @Before
    private ClickLog initClicks(){
        ClickLog clickLog = new ClickLog();
        clickLog.setClickPosition("p_001");
        clickLog.setPageCode("page_001");
        clickLog.setPageContent("广告页面");
        clickLog.setUrl("http://test.ad.com");
        return clickLog;
    }

    @Test(timeout = 1000)
    public void saveClicksLogTest() throws IllegalArgumentException,
            IllegalAccessException{
        Document document = ConvertUtil.convertDoc(this.initClicks());
        mongoClient.getDatabase("ClickLogTest").getCollection("clickLog")
                .insertOne(document);
    }

    @Test(timeout = 1000)
    public void queryClicksLogTest(){
        long count = mongoClient.getDatabase("ClicksLogTest").getCollection("clicksLog").count(new Document("clickPosition","p_001"));
        System.out.println(count);
    }

    @After
    public void closeMongoClient(){
        mongoClient.close();
    }
