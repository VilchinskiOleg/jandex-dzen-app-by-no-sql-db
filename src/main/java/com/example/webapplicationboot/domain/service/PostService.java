package com.example.webapplicationboot.domain.service;

import static com.example.webapplicationboot.domain.service.processor.UpdatePostProcessor.ProcessType;

import com.example.webapplicationboot.domain.model.post.Post;
import com.example.webapplicationboot.domain.service.processor.UpdatePostProcessor;
import java.util.List;

public interface PostService {

    void injectNewProcessor(ProcessType type, UpdatePostProcessor processor);

    List<Post> getAllPosts();
//    Post GetPostById(String id);
//    Post getPostByTitle(String title);
//    void createPost(Post post);
//    void updatePost(Post post, ProcessType processType);
//    void deletePostById(String id);
}
