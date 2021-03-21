package com.example.webapplicationboot.rest.service;

import com.example.webapplicationboot.domain.model.post.Post;
import com.example.webapplicationboot.domain.service.PostService;
import com.example.webapplicationboot.rest.model.post.PostResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/post")
public class PostRest {

    private final PostService postService;

    @GetMapping
    public PostResponse getAllPosts() {
        List<Post> allPosts = postService.getAllPosts();
        return new PostResponse();
    }
}
