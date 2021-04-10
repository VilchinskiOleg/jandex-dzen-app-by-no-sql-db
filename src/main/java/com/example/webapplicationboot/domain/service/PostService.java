package com.example.webapplicationboot.domain.service;

import static com.example.webapplicationboot.domain.service.processor.UpdatePostProcessor.ProcessType;

import com.example.webapplicationboot.domain.model.post.Post;
import com.example.webapplicationboot.domain.service.processor.UpdatePostProcessor;
import java.util.List;

public interface PostService {

    void injectNewProcessor(ProcessType type, UpdatePostProcessor processor);

    List<Post> getAllPosts();
    List<Post> getPostsPage(int numberPage, int sizePage);
//    Post GetPostById(String id);
//    Post getPostByTitle(String title);
    Post createPost(Post post);
    Post updatePost(Post postData, ProcessType processType);
//    void deletePostById(String id);
}
