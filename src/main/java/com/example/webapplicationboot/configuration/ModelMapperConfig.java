package com.example.webapplicationboot.configuration;

import com.example.webapplicationboot.domain.mapper.SmartModelMapper;
import com.example.webapplicationboot.domain.mapper.converter.BaseConverter;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.annotation.Resource;
import java.util.List;

@Configuration
public class ModelMapperConfig {

    @Resource
    private List<BaseConverter<?, ?>> converters;

    @Bean(name = "mapper")
    public SmartModelMapper configurerModelMapper() {
        SmartModelMapper mapper = new SmartModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        converters.forEach(converter -> {
            converter.setMapper(mapper);
            mapper.addConverter(converter);
        });
        return mapper;
    }
}
