package com.side.backend.demo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.MessageSource;


@Slf4j
@RequiredArgsConstructor
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)    //	exclude  : 	security dependency delete
public class SideProjectApplication {

    private final MessageSource messageSource;

    public static void main(String[] args) {
        SpringApplication.run(SideProjectApplication.class, args);
    }

}
