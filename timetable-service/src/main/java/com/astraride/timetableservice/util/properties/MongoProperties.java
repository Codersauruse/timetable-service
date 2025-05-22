package com.astraride.timetableservice.util.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.data.mongodb")
public class MongoProperties {
    private String uri;
    private String database;

    // Default constructor
    public MongoProperties() {}

    // Getters and setters
    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    @Override
    public String toString() {
        return "MongoProperties{" +
                "uri='" + uri + '\'' +
                ", database='" + database + '\'' +
                '}';
    }

}
