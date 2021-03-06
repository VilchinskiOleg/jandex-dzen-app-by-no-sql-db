package com.example.webapplicationboot.domain.mapper.converter;

import lombok.Getter;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;


public abstract class BaseConverter<S, D> implements Converter<S, D> {

//    @Resource
//    protected SmartModelMapper modelMapper;

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
