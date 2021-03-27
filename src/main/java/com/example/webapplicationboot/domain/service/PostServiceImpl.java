package com.example.webapplicationboot.domain.service;

import static com.example.webapplicationboot.domain.service.processor.UpdatePostProcessor.ProcessType;
import static java.util.Collections.emptyMap;
import static java.util.Objects.isNull;
import static org.springframework.data.domain.PageRequest.of;

import com.example.webapplicationboot.domain.mapper.SmartModelMapper;
import com.example.webapplicationboot.domain.model.post.Post;
import com.example.webapplicationboot.domain.service.processor.UpdatePostProcessor;
import com.example.webapplicationboot.persistent.repository.PostRepository;
import com.example.webapplicationboot.persistent.repository.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.*;

@Service
public class PostServiceImpl implements PostService {

    @Resource
    private UserRepository userRepository;
    @Resource
    private PostRepository postRepository;
    @Resource
    private SmartModelMapper mapper;
    private final Map<ProcessType, UpdatePostProcessor> processors = new HashMap<>();

    @Override
    public void injectNewProcessor(ProcessType type, UpdatePostProcessor processor) {
        processors.put(type, processor);
    }

    @Override
    public List<Post> getAllPosts() {
        var posts = postRepository.findAll();
        return mapper.map(posts, new ArrayList<>(), Post.class);
    }

    @Override
    public List<Post> getPostsPage(int numberPage, int sizePage) {
        PageRequest request = of(numberPage,sizePage);
        var page = postRepository.findAll(request);
        System.out.printf("Number of page: %d \nQuantity items in one page: %d", page.getNumber(), page.getSize()); // потом сюда поставить логер
        return mapper.map(page.getContent(), new ArrayList<>(), Post.class);
    }

//    @Override
//    public Post getPostByTitle(String title) {
//        var post = postRepository.findAllByTitle(title).stream()
//                                .findAny()
//                                .orElseGet(PostUtil::getEmptyEntityPost);
//        return modelMapper.map(post, Post.class);
//    }

//    @Override
//    public Post GetPostById(long id) {
//        if (id <= 0) {
//            throw new IllegalArgumentException("Id is not correct!");
//        }
//        Optional<Post> postBox = postRepository.findById(id);
//        Post post = postBox.orElseThrow(NotFoundPostByTitleException::new);
//        return postHandler(post);
//    }
//
//    @Override
//    public void createPost(Post post) {
//        if (post == null) {
//            throw new IllegalArgumentException("Post is null!");
//        }
//        postRepository.save(post);
//    }

    @Override
    public Post updatePost(Post postData, ProcessType processType) {
        UpdatePostProcessor processor = processors.get(processType);
        if (isNull(processor)) {
            throw new RuntimeException("External server error: Such process type doesn't exist");
        }
        Post post = processor.process(postData);
        postRepository.save(mapper.map(post, com.example.webapplicationboot.persistent.entity.post.Post.class));
        return post;
    }
}
