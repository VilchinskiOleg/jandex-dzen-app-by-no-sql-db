package com.example.webapplicationboot.persistent.repository;

import com.example.webapplicationboot.persistent.entity.post.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {
    List<Post> findAllByTitle(String title);
}
