package com.example.webapplicationboot.persistent.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collation = "posts")
public class User {

    @Id
    private String id;

    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private int age;
}
