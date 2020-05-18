package com.ecommerce.demo.service;

import com.ecommerce.demo.Repository.UserRepository;
import com.ecommerce.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }

    public User findByUserNameAndPassWord(String userName, String passWord) {
        return userRepository.findByUserNameAndPassWord(userName, passWord);
    }
}
