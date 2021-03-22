package com.example.webapplicationboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@EnableMongoRepositories(basePackages = "com.example.webapplicationboot.persistent.repository")
@SpringBootApplication
public class WebApplicationBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplicationBootApplication.class, args);
    }

}
