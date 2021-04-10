package com.example.webapplicationboot.rest.service;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import com.example.webapplicationboot.domain.mapper.SmartModelMapper;
import com.example.webapplicationboot.domain.model.post.Post;
import com.example.webapplicationboot.domain.service.PostService;
import com.example.webapplicationboot.rest.model.post.PostRequest;
import com.example.webapplicationboot.rest.model.post.PostResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/post")
public class PostRest {

    private final PostService postService;
    private final SmartModelMapper mapper;

    @GetMapping
    @ResponseStatus(OK)
    public PostResponse getAllPosts() {
        List<Post> allPosts = postService.getAllPosts();
        return new PostResponse();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public PostResponse createPost(@RequestBody @Valid PostRequest postRequest) {
        var post = mapper.map(postRequest.getPost(), Post.class);
        postService.createPost(post);
        return new PostResponse();
    }


    /**
     * Checking:
     */
    @ExceptionHandler(value = Exception.class)
    public void exceptionHandler(Exception e) {
        String m = e.getMessage();
    }
}
