package com.example.webapplicationboot.domain.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
public class User {

    private String id;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private int age;
}
