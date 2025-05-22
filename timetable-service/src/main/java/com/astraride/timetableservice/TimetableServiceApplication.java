package com.astraride.timetableservice;

import com.astraride.timetableservice.repository.BusRepo;
import com.astraride.timetableservice.util.properties.MongoProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = BusRepo.class)
@EnableConfigurationProperties(MongoProperties.class)
public class TimetableServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimetableServiceApplication.class, args);
	}

}
