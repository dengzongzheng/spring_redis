package com.dzz.service;

import com.dzz.domain.Book;
import com.dzz.domain.User;
import com.mongodb.Mongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dengzongzheng on 16-7-20.
 */
@Service
public class HelloWordService {


    @Autowired
    private MongoTemplate mongoTemplate;

    @Cacheable(keyGenerator = "keyGenerator",value = "userCache")
    public User getUser(String name,String passWord){
        User user  =  new User();
        user.setName(name);
        user.setPassWord(passWord);
        System.out.println("缓存没命中........");
        return user;
    }

    public List<Book> getBooks(){
        Query query = new Query();
        query.addCriteria(Criteria.where("pages").gt(38));
        List<Book> books = mongoTemplate.find(query,Book.class,"book");
        return books;
    }



}
