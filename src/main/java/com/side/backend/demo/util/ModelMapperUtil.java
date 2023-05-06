package com.side.backend.demo.util;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperUtil {
    public static final ModelMapper modelMapper = new ModelMapper();

    public static <T> T comModelMapper(Object source, Class<T> destinationType) {
        return modelMapper.map(source, destinationType);
    }

}
