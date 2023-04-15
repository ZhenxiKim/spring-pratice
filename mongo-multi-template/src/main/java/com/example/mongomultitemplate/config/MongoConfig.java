package com.example.mongomultitemplate.config;


import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ReadConcern;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {

    private final MultipleMongoProps mongoProps;

    public MongoConfig(MultipleMongoProps mongoProps) {
        this.mongoProps = mongoProps;
    }

    @Primary
    @Bean
    public MongoClient firstMongoClient() {
        return MongoClients.create(createMongoClientSettings(mongoProps.getFirst()));
    }

    @Bean
    public MongoClient secondMongoClient() {
        return MongoClients.create(createMongoClientSettings(mongoProps.getSecond()));
    }

    @Bean
    public MongoClient thirdMongoClient() {
        return MongoClients.create(createMongoClientSettings(mongoProps.getThird()));
    }


    @Primary
    @Bean("firstMongoTemplate")
    public MongoTemplate firstMongoTemplate() {
        return new MongoTemplate(firstMongoClient(), mongoProps.getFirst().getDatabase());
    }

    @Bean("secondMongoTemplate")
    public MongoTemplate secondMongoTemplate() {
        return new MongoTemplate(secondMongoClient(), mongoProps.getSecond().getDatabase());
    }

    @Bean("thirdMongoTemplate")
    public MongoTemplate thirdMongoTemplate() {
        return new MongoTemplate(thirdMongoClient(), mongoProps.getThird().getDatabase());
    }


    private MongoClientSettings createMongoClientSettings(MongoProperties mongoProperties) {
        ConnectionString ConnectionString = new ConnectionString(mongoProperties.getUri());
        return MongoClientSettings.builder()
                .readConcern(ReadConcern.DEFAULT)
                .writeConcern(WriteConcern.MAJORITY)
                //.readPreference(ReadPreference.primary())
                .applyConnectionString(ConnectionString)
                .build();
    }
}
