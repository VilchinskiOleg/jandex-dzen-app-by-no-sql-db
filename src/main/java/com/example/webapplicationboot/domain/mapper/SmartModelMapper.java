package com.example.webapplicationboot.domain.mapper;

import org.modelmapper.ModelMapper;
import java.util.Collection;

public class SmartModelMapper extends ModelMapper implements SmartMapperLogics {

    public SmartModelMapper() {
        super();
    }

    @Override
    public <E extends Collection<D>, D> E map(Collection<?> sources, E destinations, Class<D> destinationType) {
        sources.forEach(source -> destinations.add(super.map(source, destinationType)));
        return destinations;
    }
}
