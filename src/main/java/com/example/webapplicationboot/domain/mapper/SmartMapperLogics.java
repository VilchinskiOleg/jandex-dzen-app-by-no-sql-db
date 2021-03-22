package com.example.webapplicationboot.domain.mapper;

import java.util.Collection;

public interface SmartMapperLogics {

    <E extends Collection<D>, D> E map(Collection<?> sources, E destinations, Class<D> destinationType);
}
