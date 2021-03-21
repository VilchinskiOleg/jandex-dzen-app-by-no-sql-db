package com.example.webapplicationboot.configuration;

import com.example.webapplicationboot.domain.mapper.converter.EntityCommentToCommentConverter;
import com.example.webapplicationboot.domain.mapper.converter.EntityLikeToLikeConverter;
import com.example.webapplicationboot.domain.mapper.converter.EntityPostToPostConverter;
import com.example.webapplicationboot.domain.model.post.Comment;
import com.example.webapplicationboot.domain.model.post.Like;
import com.example.webapplicationboot.persistent.entity.post.Post;
import lombok.AllArgsConstructor;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.List;

@Configuration
@AllArgsConstructor
public class ModelMapperConfig {

//    @Resource
//    private List<Converter<?, ?>> converters;

    private final EntityCommentToCommentConverter entityCommentToCommentConverter;
    private final EntityLikeToLikeConverter entityLikeToLikeConverter;
    private final EntityPostToPostConverter entityPostToPostConverter;

    @Bean(name = "modelMapper")
    public ModelMapper configurerModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        modelMapper.typeMap(Post.class, com.example.webapplicationboot.domain.model.post.Post.class)
                .addMappings(mapper -> {

                    mapper
                            .using(entityLikeToLikeConverter)
                            .map(Post::getLike, com.example.webapplicationboot.domain.model.post.Post::setLike);
                    mapper
                            .using(entityCommentToCommentConverter)
                            .<Comment>map(Post::getComment, (dst, var) -> dst.setComment(var));
                });

        modelMapper.addConverter(entityCommentToCommentConverter);
        modelMapper.addConverter(entityLikeToLikeConverter);

        return modelMapper;
    }
}
