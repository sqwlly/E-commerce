package com.ecommerce.demo.controller;

import com.ecommerce.demo.auth.LoginRequired;
import com.ecommerce.demo.model.Good;
import com.ecommerce.demo.model.UpLoadFile;
import com.ecommerce.demo.service.GoodService;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

@Controller("/good")
@RequestMapping("/good")
public class GoodController {
    @Autowired
    private GoodService goodService;

    @LoginRequired
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("goods", goodService.findAll());
        goodService.findAll().forEach(e -> System.out.println(e.getGoodId() + " " + e.getGoodInfo()));
        System.out.println(goodService.count());
        return "/good/list";
    }

    @LoginRequired
    @RequestMapping("/create")
    public String create(Model model) {
        return "/good/create";
    }

    @LoginRequired
    @RequestMapping("/save")
    public String save(@RequestParam String goodInfo, @RequestParam String specificationInfo,
                       @RequestParam String price, @RequestParam int num,@RequestParam MultipartFile file) {
        UpLoadFile img = goodService.upLoad(file);
        Good good = new Good(goodInfo, specificationInfo, price, num, img);
        goodService.save(good);
        return "redirect:/good/show/" + good.getGoodId();
    }

    @LoginRequired
    @GetMapping(value = "/getGoodImage/{goodId}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    @ResponseBody
    public byte[] getGoodImage(@PathVariable String goodId) {
        return goodService.getGoodImage(goodId);
    }

    @LoginRequired
    @RequestMapping("/show/{goodId}")
    public String show(@PathVariable String  goodId, Model model) {
        model.addAttribute("good", goodService.findByGoodId(goodId));
        return "/good/show";
    }

    @LoginRequired
    @RequestMapping("/delete")
    public String delete(@RequestParam String Id) {
        goodService.delete(goodService.findByGoodId(Id));
        return "redirect:/good/list";
    }

    @LoginRequired
    @RequestMapping("/edit/{ID}")
    public String edit(@PathVariable String Id, Model model) {
        model.addAttribute("good", goodService.findByGoodId(Id));
        return "/good/edit";
    }

    @LoginRequired
    @RequestMapping("/update")
    public String update(@RequestParam String Id, @RequestParam String goodInfo, @RequestParam String specificationInfo) {
        Good good = goodService.findByGoodId(Id);
        good.setGoodId(Long.parseLong(Id));
        good.setGoodInfo(goodInfo);
        good.setSpecificationInfo(specificationInfo);
        //good.setAdInfo(adInfo);
        goodService.save(good);
        return "redirect:/good/show/" + good.getGoodId();
    }
}
