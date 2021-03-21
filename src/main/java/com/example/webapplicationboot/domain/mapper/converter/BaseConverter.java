package com.example.webapplicationboot.domain.mapper.converter;

import lombok.Getter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;


public abstract class BaseConverter<S, D> implements Converter<S, D> {

//    protected ModelMapper modelMapper;
//
//    @PostConstruct
//    private void setModelMapper(@Autowired ModelMapper modelMapper) {
//        this.modelMapper = modelMapper;
//    }

    @Override
    public D convert(MappingContext<S, D> mappingContext) {
        S source = mappingContext.getSource();
        D destination = getDestination();
        convert(source, destination);
        return destination;
    }

    protected abstract D getDestination();
    public abstract void convert(S source, D destination);
}
