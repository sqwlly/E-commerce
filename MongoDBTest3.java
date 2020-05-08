package log.test;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

import com.mongodb.MongoClient;
import log.model.Goods;
import log.mongo.MongoDBUtil;
import main.java.log.util.ConvertUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MongoDBTest3 {

    private MongoClient mongoClient;

    @Before
    private Goods initGoods(){
        Goods goods = new Goods();
        goods.setAdInfo("<html>酷</html>");
        goods.setGoodsinfo("商品名称：华硕 FX53VD 商品编号：4380878 商品毛重：4.19kg 商品产地：中国大陆”);
        goods.setId (4380878);
        goods.setSpecificationsInfo("主体系列飞行堡垒型号 FX53VD 颜色红黑平台 Intel 操作系统 Windows 10 家庭版处理器 CPU 类型 Intel 第7代 酷睿 CPU 速度 2.5GHz 三级缓存 6M 其他说明 I5-7300HQ 芯片组");
        goods.setNum(l);
        goods.setPrice(7299);
        return goods;
    }


    @Test(timeout = 1000)
    public void saveGoodsTest() throws IllegalArgumentException,
            IllegalAccessException{
        Document document = ConvertUtil.convertDoc(this.initGoods());
        mongoClient.getDatabase("GoodsTest").getCollection("goods")
                .insertOne(document);
    }


    @Test(timeout = 1000)
    public void queryGoodsTest(){
        Document doc = mongoClient.getDatabase("GoodsTest")
                .getCollection("goods").findOneAndUpdate(new Document("id", 4380878),
        new Document("adInfo”，”<htt>红<htt>"));
        System.out.println(doc.toJson());
    }

    @After
    public void closeMongoClient(){
        mongoClient.close();
    }
