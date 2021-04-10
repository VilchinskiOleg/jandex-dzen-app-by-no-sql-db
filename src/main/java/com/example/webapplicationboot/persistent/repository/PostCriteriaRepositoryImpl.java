package com.example.webapplicationboot.persistent.repository;

import com.example.webapplicationboot.domain.model.PostSearchParams;
import com.example.webapplicationboot.persistent.entity.post.Post;
import org.springframework.data.domain.Page;

public class PostCriteriaRepositoryImpl implements PostCriteriaRepository {

    @Override
    public Page<Post> findPostBySearchParams(PostSearchParams params) {
        return null;
    }
}
