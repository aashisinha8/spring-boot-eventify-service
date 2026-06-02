
package com.eventify.eventify_service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class MongoCheck {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Value("${spring.data.mongodb.database}")
    private String dbName;

    @PostConstruct
    public void init() {
        System.out.println("PROPERTY DB = " + dbName);
        System.out.println("CURRENT DB = " + mongoTemplate.getDb().getName());
    }
}