package com.example.webapplicationboot.configuration.bpp;

import com.example.webapplicationboot.domain.mapper.SmartModelMapper;
import com.example.webapplicationboot.domain.mapper.converter.BaseConverter;
import com.example.webapplicationboot.util.annotation.BppMarker;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * @Component (uncomment for using/testing)
 * doesn't work now because BPP process single bean, witch doesn't injected to class with annotation @Configuration
 **/
public class ModelMapperBeanPostProcessor implements BeanPostProcessor {

    @Resource
    private SmartModelMapper mapper;
    private final Set<String> processBeanNames = new HashSet<>();

    /**
     * Common rule: (logics before creating proxy, bean is original class yet)
     **/
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        var beanClass = bean.getClass();
        if (beanClass.isAnnotationPresent(BppMarker.class)) {
            processBeanNames.add(beanName);
            System.out.printf("Bean with name \"%s\" mark as process\n", beanName);
        }
        return bean;
    }

    /**
     * Common rule: (logics after creating proxy, bean must be proxy but its name doesn't change)
     **/
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (processBeanNames.contains(beanName)) {
            ((BaseConverter<?, ?>) bean).setModelMapper(mapper);
            System.out.printf("Added mapper to bean with name \"%s\"\n", beanName);
        }
        return bean;
    }
}
