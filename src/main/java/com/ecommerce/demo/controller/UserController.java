package com.ecommerce.demo.controller;

import com.ecommerce.demo.Repository.GoodRepository;
import com.ecommerce.demo.Repository.UserRepository;
import com.ecommerce.demo.auth.LoginRequired;
import com.ecommerce.demo.config.WebConfig;
import com.ecommerce.demo.model.User;
import com.ecommerce.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.WebSecurityEnablerConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;


@Controller("/user")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "/user/login";
    }

    @RequestMapping("/auth")
    public String auth(@RequestParam("userName") String userName, @RequestParam("passWord") String passWord, Map<String,Object> map,
                              HttpSession session) {
        User user = userService.findByUserNameAndPassWord(userName, passWord);
        if(user != null) {
            session.setAttribute("USER", userName);
            System.out.println("登陆成功----" + userName);
            map.put("status", true);
            map.put("msg", "登录成功！");
            return "redirect:/good/list";
        }else{
            session.invalidate();
            map.put("status", false);
            map.put("msg", "用户名或者密码错误！");
            return "/user/login";
        }
    }

    @GetMapping("/register")
    public ModelAndView register() {
        return new ModelAndView("/user/register");
    }

    @RequestMapping("/registerPost")
    public String registerPost(@RequestParam("userName") String userName, @RequestParam("passWord") String passWord, @RequestParam("name") String name,
                               @RequestParam("gender") String gender, @RequestParam("age") String age, @RequestParam("school") String school, Map<String,Object> map,
                               HttpSession session) {
        User user = new User(userName, passWord, name, gender, age, school);
        userService.save(user);
        session.setAttribute("USER", userName);
        System.out.println("----" + userName);
        map.put("status", true);
        map.put("msg", "登录成功！");
        return "redirect:/good/list";
    }

    @LoginRequired
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute(WebConfig.SESSION_KEY);
        return "redirect:/user/login";
    }
}

