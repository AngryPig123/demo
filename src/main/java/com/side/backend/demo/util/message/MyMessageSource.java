package com.side.backend.demo.util.message;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@RequiredArgsConstructor
public class MyMessageSource {

    private final MessageSource messageSource;


    public String getMessage(String messageCode) {
        return messageSource.getMessage(messageCode, null, Locale.KOREAN);
    }

}
