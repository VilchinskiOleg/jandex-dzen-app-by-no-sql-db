package com.example.webapplicationboot.configuration;

import com.example.webapplicationboot.domain.mapper.converter.EntityCommentToCommentConverter;
import com.example.webapplicationboot.domain.mapper.converter.EntityLikeToLikeConverter;
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

    @Bean(name = "modelMapper")
    public ModelMapper configurerModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        modelMapper.typeMap(Post.class, com.example.webapplicationboot.domain.model.post.Post.class)
                .addMappings(mapper -> {

                    mapper
                            .using(entityLikeToLikeConverter)
                            .<Like>map(src -> src.getLike(), (dst, var) -> dst.setLike(var));
                    mapper
                            .using(entityCommentToCommentConverter)
                            .<Comment>map(src -> src.getComment(), (dst, var) -> dst.setComment(var));
                });

        return modelMapper;
    }
}
