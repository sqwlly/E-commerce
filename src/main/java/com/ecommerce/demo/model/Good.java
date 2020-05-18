package com.ecommerce.demo.model;

import com.ecommerce.demo.Repository.AutoIncKey;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "good")
public class Good {
    /** 商品ID **/
    @AutoIncKey
    private long goodId;
    /** 商品基本信息 **/
    private String goodInfo;
    /** 规格信息 **/
    private String specificationInfo;
    /** 商品价格 **/
    private String price;
    /** 广告信息 **/
    //private String adInfo;
    /** 数量 **/
    private int num;

    private UpLoadFile file;

    public Good() {

    }

    public Good(String goodInfo, String specificationInfo, String price, int num, UpLoadFile file) {
        this.goodInfo = goodInfo;
        this.specificationInfo = specificationInfo;
        this.price = price;
        //this.adInfo = adInfo;
        this.num = num;
        this.file = file;
    }

    public long getGoodId() {
        return goodId;
    }

    public void setGoodId(long goodId) {
        this.goodId = goodId;
    }

    public String getGoodInfo() {
        return goodInfo;
    }

    public void setGoodInfo(String goodInfo) {
        this.goodInfo = goodInfo;
    }

    public String getSpecificationInfo() {
        return specificationInfo;
    }

    public void setSpecificationInfo(String specificationInfo) {
        this.specificationInfo = specificationInfo;
    }

    /*public String getAdInfo() {
        return adInfo;
    }

    public void setAdInfo(String adInfo) {
        this.adInfo = adInfo;
    }
    */
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public UpLoadFile getFile() {
        return file;
    }

    public void setFile(UpLoadFile file) {
        this.file = file;
    }
}
