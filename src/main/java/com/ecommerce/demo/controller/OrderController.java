package com.ecommerce.demo.controller;

import com.ecommerce.demo.auth.LoginRequired;
import com.ecommerce.demo.model.Order;
import com.ecommerce.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller("/order")
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @LoginRequired
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("orders", orderService.findAll());
        System.out.println(orderService.count());
        return "/order/list";
    }

    @LoginRequired
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestParam String userName, @RequestParam String cart, Map<String,Object> map) {
        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println("当前时间为: " + ft.format(dNow));
        orderService.save(new Order(userName, cart, new Date()));
        map.put("status", true);
        map.put("msg", "购买成功！");
        return "redirect:/component/success";
    }
}
