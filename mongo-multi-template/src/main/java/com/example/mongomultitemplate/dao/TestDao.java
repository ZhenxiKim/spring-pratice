package com.example.mongomultitemplate.dao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;


@Slf4j
@RequiredArgsConstructor
@Component
public class TestDao {
    private final MongoTemplate thirdMongoTemplate;

    public void findAll() {
      log.info("thirdMongoTemplate : {}", thirdMongoTemplate.getDb().getName());
    }
}
