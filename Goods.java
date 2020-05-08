package log.model;
import java.util.Date;

/**
 * @描述：商品信息
 * @创建者：王诗玥
 * @创建日期：2020/5/8
 */

public class Goods{
    private int id;
    private String goodsInfo ;
    private String specificationsInfo
    private String adInfo;
    private int num;
    private int price;

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getGoodsInfo(){
        return goodsInfo;
    }
    public void setGoodsInfo(String goodsInfo){
        this.goodsInfo=goodsInfo;
    }
    public String getSpecificationsInfo(){
        return specificationsInfo;
    }
    public void setSpecificationsInfo(String specificationsInfo){
        this.specificationsInfo=specificationsInfo;
    }
    public String getAdInfo(){
        return adInfo;
    }
    public void setAdInfo(String adInfo){
        this.adInfo=adInfo;
    }
    public int getNum(){
        return num;
    }
    public void setNum(int num){
        this.num=num;
    }
    public int getPrice(){
        return price;
    }
    public void setPrice(int price){
        this.price=price;
    }
}
