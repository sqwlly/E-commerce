package com.ecommerce.demo.controller;

import com.ecommerce.demo.model.Good;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController("/Index")
@RequestMapping("/Index")
public class IndexController {
    @RequestMapping("/Hello")
    public String Hello() {
        return "Hello";
    }

    @RequestMapping("/test")
    public ModelAndView Test() {
        ModelAndView goods = new ModelAndView("/view/user/goods");
        Good good = new Good();
        good.setGoodId(1);
       // good.setAdInfo("testinfo");
        good.setGoodInfo("goodinfo");
        good.setSpecificationInfo("specificationinfo");

       // System.out.println(good.getAdInfo());
        return goods;
    }
}
