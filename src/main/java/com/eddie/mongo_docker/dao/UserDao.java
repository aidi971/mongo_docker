package com.eddie.mongo_docker.dao;

import com.eddie.mongo_docker.entity.User;
import org.springframework.scheduling.support.SimpleTriggerContext;

import java.util.List;

/**
 * @Author: eddie
 * @Date: 2021/2/4 11:06
 **/
public interface UserDao {
    void save(User user);
    void update(User user);
    List<User> findAll();
    void delete(String id);
}
