package com.example.webapplicationboot.domain.service;

import static com.example.webapplicationboot.domain.service.processor.UpdatePostProcessor.ProcessType;

import com.example.webapplicationboot.domain.model.post.Post;
import com.example.webapplicationboot.domain.service.processor.UpdatePostProcessor;
//import com.example.webapplicationboot.persistent.repopsitory.PostRepository;
//import com.example.webapplicationboot.persistent.repopsitory.UserRepository;
import com.example.webapplicationboot.util.PostUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.*;

@Service
public class PostServiceImpl implements PostService {

//    @Resource
//    private UserRepository userRepository;
//    @Resource
//    private PostRepository postRepository;
    @Resource
    private ModelMapper modelMapper;
    private Map<ProcessType, UpdatePostProcessor> processors = new HashMap();

    @Override
    public void injectNewProcessor(ProcessType type, UpdatePostProcessor processor) {
        processors.put(type, processor);
    }

    @Override
    public List<Post> getAllPosts() {
//        Collection<Post> posts = modelMapper.map(postRepository.findAll(), new ArrayList<>(), Post.class);
        Post post = modelMapper.map(PostUtil.getEmptyEntityPost(), Post.class);
        return Collections.singletonList(post);
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
//
//    @Override
//    public void setComment(Comment comment) {
//        if (comment == null) {
//            throw new IllegalArgumentException("Comment is null!");
//        }
//        commentRepository.save(comment);
//    }
//
//    @Override
//    public void setLike(Like like) {
//        if (like == null) {
//            throw new IllegalArgumentException("Comment is null!");
//        }
//        likeRepository.save(like);
//    }
}
