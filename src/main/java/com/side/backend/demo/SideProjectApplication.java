package com.side.backend.demo;

import com.side.backend.demo.dto.login.req.UserLoginReq;
import com.side.backend.demo.dto.user.UserInfoDto;
import com.side.backend.demo.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.MessageSource;

import javax.annotation.PostConstruct;
import javax.persistence.PersistenceException;
import java.util.Locale;


@Slf4j
@RequiredArgsConstructor
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)    //	exclude  : 	security dependency delete*/
public class SideProjectApplication {

    private final UserInfoService userInfoService;
    private final MessageSource messageSource;

    public static void main(String[] args) {
        SpringApplication.run(SideProjectApplication.class, args);
    }

/*
    @PostConstruct
    private void initUserSetting() {

        String firstName = messageSource.getMessage("init.first.name", null, Locale.KOREAN);
        String lastName = messageSource.getMessage("init.last.name", null, Locale.KOREAN);
        String email = messageSource.getMessage("init.email", null, Locale.KOREAN);
        String password = messageSource.getMessage("init.password", null, Locale.KOREAN);

        UserInfoDto userInfoDto = UserInfoDto.builder()
                .firstName(firstName)
                .lastName(lastName)
                .userEmailAddress(email)
                .userPassword(password)
                .repeatPassword(password)
                .build();

        log.info("userInfoDto = {}", userInfoDto);


        userInfoService.registerUser(userInfoDto);


        UserLoginReq userLoginReq = UserLoginReq.builder()
                .userEmailAddress(email)
                .userPassword(password)
                .build();

        log.error("error = {}", userInfoService.userLogin(userLoginReq));

    }
*/

}
