package com.eddie.mongo_docker.dao.impl;

import com.eddie.mongo_docker.dao.UserDao;
import com.eddie.mongo_docker.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: eddie
 * @Date: 2021/2/4 11:13
 **/
@Component
public class UserDaoImpl implements UserDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void save(User user) {
        mongoTemplate.save(user);
    }

    @Override
    public void update(User user) {
        Query query = new Query(Criteria.where("id").is(user.getId()));
        Update update = new Update();
        update.set("name",user.getName());
        mongoTemplate.updateFirst(query,update,User.class);
    }

    @Override
    public List<User> findAll() {
        return mongoTemplate.findAll(User.class);
    }

    @Override
    public void delete(String id) {
        User user = mongoTemplate.findById(id,User.class);
        mongoTemplate.remove(user);
    }
}
