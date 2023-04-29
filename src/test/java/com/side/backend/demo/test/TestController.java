package com.side.backend.demo.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
public class TestController {

    @Autowired
    MessageSource messageSource;


    @Test
    public void test() {
        String result = messageSource.getMessage("user.info.validation.password.repeat.message", null,Locale.KOREAN);
        Assertions.assertEquals(result, "비밀번호가 맞지 않습니다.");
    }

}
