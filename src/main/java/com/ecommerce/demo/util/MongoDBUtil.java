package com.ecommerce.demo.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientOptions.Builder;
import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;

public class MongoDBUtil {

    public static MongoClient initMongo() throws IOException{
        // 加载mongo配置文件
        InputStream inputStream = MongoDBUtil.class.getClassLoader().getResourceAsStream("mongodb.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        WriteConcern concern = new WriteConcern(
                Integer.parseInt(properties.getProperty("write")),
                Integer.parseInt(properties.getProperty("writeTimeout")));
        concern.withJournal(Boolean.valueOf(properties.getProperty("journal")));
        Builder builder = MongoClientOptions
                .builder()
                .connectionsPerHost(
                        Integer.parseInt(properties.getProperty("connectionsPerHost")))
                .connectTimeout(
                        Integer.parseInt(properties.getProperty("connectTimeout")))
                .cursorFinalizerEnabled(
                        Boolean.parseBoolean(properties.getProperty("cursorFinalizerEnabled")))
                .maxWaitTime(
                        Integer.parseInt(properties.getProperty("maxWaitTime")))
                .threadsAllowedToBlockForConnectionMultiplier(
                        Integer.parseInt(properties.getProperty("threadsAllowedToBlockForConnectionMultiplier")))
                .socketTimeout(
                        Integer.parseInt(properties.getProperty("socketTimeout")))
                .socketKeepAlive(
                        Boolean.parseBoolean(properties.getProperty("socketKeepAlive")))
                .writeConcern(concern);
        if (Boolean.parseBoolean(properties.getProperty("readSecondary"))) {
            builder.readPreference(ReadPreference.secondaryPreferred());
        }
        String[] address = properties.getProperty("hostConfString").split(":");
        ServerAddress serverAddress = new ServerAddress(address[0],
                Integer.parseInt(address[1]));
        return new MongoClient(serverAddress, builder.build());
    }

}