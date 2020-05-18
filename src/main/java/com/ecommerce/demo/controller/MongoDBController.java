package com.ecommerce.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import org.bson.Document;
import com.ecommerce.demo.util.*;
import com.ecommerce.demo.model.*;

public class MongoDBController {

    private MongoClient mongoClient;

    public void initMongoClient() throws IOException{
        mongoClient = MongoDBUtil.initMongo();
    }

    public void saveLogTest() throws IllegalArgumentException,
            IllegalAccessException{
        mongoClient.getDatabase("LogTest").getCollection("log")
                .insertOne(ConvertUtil.convertDoc(this.initLog()));
    }

    public void closeMongoClient(){
        mongoClient.close();
    }

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
