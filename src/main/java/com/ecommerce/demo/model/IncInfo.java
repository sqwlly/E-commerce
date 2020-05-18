package com.ecommerce.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "inc")
public class IncInfo {
    //主键
    @Id
    private String ID;
    //自建主键集合名称
    @Field
    private String collName;
    //当前自增ID值
    @Field
    private Integer incID;

    public IncInfo() {}

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getCollName() {
        return collName;
    }

    public void setCollName(String collName) {
        this.collName = collName;
    }

    public Integer getIncID() {
        return incID;
    }

    public void setIncID(Integer incID) {
        this.incID = incID;
    }
}
