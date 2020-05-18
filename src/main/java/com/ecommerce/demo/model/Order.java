package com.ecommerce.demo.model;

import com.ecommerce.demo.Repository.AutoIncKey;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "order")
public class Order {

    @AutoIncKey
    /** 订单ID **/
    private long orderId;
    /** 下单时间 **/
    private Date createdDate;
    /** 下单用户 **/
    private String userName;
    /** 购买商品json **/
    private String goodsList;

    public Order() {}

    public Order(String userName, String goodsList, Date createdDate) {
        this.userName = userName;
        this.goodsList = goodsList;
        this.createdDate = createdDate;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(String goodsList) {
        this.goodsList = goodsList;
    }

}
