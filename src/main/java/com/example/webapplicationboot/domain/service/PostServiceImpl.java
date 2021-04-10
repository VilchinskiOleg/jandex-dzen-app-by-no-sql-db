package com.example.webapplicationboot.domain.service;

import static com.example.webapplicationboot.domain.service.processor.UpdatePostProcessor.ProcessType;
import static java.util.Objects.isNull;
import static org.springframework.data.domain.PageRequest.of;

import com.example.webapplicationboot.domain.mapper.SmartModelMapper;
import com.example.webapplicationboot.domain.model.post.Post;
import com.example.webapplicationboot.domain.service.processor.UpdatePostProcessor;
import com.example.webapplicationboot.persistent.repository.PostRepository;
import com.example.webapplicationboot.persistent.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.*;

@Service
@Slf4j
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
        log.info("Got list of posts from db");
        return mapper.map(posts, new ArrayList<>(), Post.class);
    }

    @Override
    public List<Post> getPostsPage(int numberPage, int sizePage) {
        PageRequest request = of(numberPage,sizePage);
        var page = postRepository.findAll(request);
        log.info("Got page of posts from db");
        log.info("Number of page: {}. Quantity items in one page: {}", page.getNumber(), page.getSize());
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
    @Override
    public Post createPost(Post postData) {
        checkPostIsValid(postData);
        var post = mapper.map(postData, com.example.webapplicationboot.persistent.entity.post.Post.class);
        log.info("Saved post to db");
        return mapper.map(postRepository.save(post), Post.class);
    }

    @Override
    public Post updatePost(Post postData, ProcessType processType) {
        UpdatePostProcessor processor = processors.get(processType);
        checkProcessorIsValid(processor);
        var post = mapper.map(processor.process(postData), com.example.webapplicationboot.persistent.entity.post.Post.class);
        log.info("Post was updated");
        return mapper.map(postRepository.save(post), Post.class);
    }

    private void checkProcessorIsValid(UpdatePostProcessor processor) {
        if (isNull(processor)) {
            log.error("Such process type doesn't exist");
            throw new RuntimeException("External server error: Such process type doesn't exist");
        }
    }

    private void checkPostIsValid(Post post) {
        if (isNull(post)) {
            log.error("Post is null");
            throw new IllegalArgumentException("External server error: Post is null");
        }
    }
}
