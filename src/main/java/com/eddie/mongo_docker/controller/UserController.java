package com.eddie.mongo_docker.controller;

import com.eddie.mongo_docker.dao.UserDao;
import com.eddie.mongo_docker.dao.impl.UserDaoImpl;
import com.eddie.mongo_docker.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: eddie
 * @Date: 2021/2/4 11:54
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserDaoImpl userDao;
    
    @PostMapping("/save")
    public void save(User user){
        userDao.save(user);
    }
    
    @PostMapping("/findList")
    public List<User> userList(){
        return userDao.findAll();
    }
}
