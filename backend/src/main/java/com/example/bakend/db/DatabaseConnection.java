package com.example.bakend.db;

import com.example.bakend.api.repo.PostRepository;
import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

public class DatabaseConnection{
    private String connectionString = "mongodb+srv://andrei:andrei@safety-fun-map.yqchk9o.mongodb.net/?retryWrites=true&w=majority";

    public MongoClient mongoClient() {
        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .serverApi(serverApi)
                .build();

        MongoClient mongoClient;

        try {
            mongoClient = MongoClients.create(settings);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return mongoClient;
    }
}
