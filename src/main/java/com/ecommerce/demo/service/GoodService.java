package com.ecommerce.demo.service;

import com.ecommerce.demo.Repository.GoodRepository;
import com.ecommerce.demo.auth.LoginRequired;
import com.ecommerce.demo.model.Good;
import com.ecommerce.demo.model.UpLoadFile;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class GoodService {
    @Autowired
    GoodRepository goodRepository;

    public UpLoadFile upLoad(@RequestParam(value = "image") MultipartFile file) {
        if(file.isEmpty()) return null;
        String fileName = file.getOriginalFilename();
        try{
            return new UpLoadFile(fileName, new Date(), new Binary(file.getBytes()), file.getContentType(), file.getSize());

        }catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public byte[] getGoodImage(@PathVariable String Id) {
        byte[] data = null;
        UpLoadFile file = findByGoodId(Id).getFile();
        if(file != null) {
            data = file.getContent().getData();
            System.out.println("found img:" + Id);
        }else{
            System.out.println("not found img:" + Id);
        }
        return data;
    }

    public void save(Good good) {
        goodRepository.save(good);
    }

    public List<Good> findAll() {
        var it = goodRepository.findAll();
        var goods = new ArrayList<Good>();
        it.forEach(e -> goods.add(e));
        goods.forEach(e -> System.out.println(e.getGoodId()));
        //goods.forEach(e -> e.ge);
        return goods;
        //return goodRepository.findAll();
    }

    /*public List<Good> listGoodByPage(int pageIndex, int pageSize) {
        Page<Good> page = null;
        List<Good> list = null;
        Pageable pageable = PageRequest.of(pageIndex, pageSize, Sort.by(Sort.Direction.DESC, "ID"));
        page = goodRepository.findAll(pageable);
    }*/

    public Page<Good> findGoodByName(String name, int pageNo, int pageSize) {
        return goodRepository.findByGoodInfo(name, PageRequest.of(pageNo - 1, pageSize));
    }

    public Long count() {
        return goodRepository.count();
    }

    public Good findByGoodId(String goodId) {
        return goodRepository.findByGoodId(Long.parseLong(goodId));
    }

    public void delete(Good good) {
        goodRepository.delete(good);
    }
}
