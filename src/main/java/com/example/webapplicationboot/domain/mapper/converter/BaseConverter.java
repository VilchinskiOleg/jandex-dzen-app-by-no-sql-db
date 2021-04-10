package com.example.webapplicationboot.domain.mapper.converter;

import com.example.webapplicationboot.domain.mapper.SmartModelMapper;
import com.example.webapplicationboot.util.annotation.BppMarker;
import lombok.Setter;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

@Setter
@BppMarker
public abstract class BaseConverter<S, D> implements Converter<S, D> {

    protected SmartModelMapper mapper;

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
