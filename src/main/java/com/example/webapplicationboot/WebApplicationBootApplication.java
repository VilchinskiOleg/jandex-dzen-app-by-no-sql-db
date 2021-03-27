package com.example.webapplicationboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@EnableMongoRepositories(basePackages = "com.example.webapplicationboot.persistent.repository")
@SpringBootApplication(scanBasePackages = "com.example.webapplicationboot")
public class WebApplicationBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplicationBootApplication.class, args);
    }

}
