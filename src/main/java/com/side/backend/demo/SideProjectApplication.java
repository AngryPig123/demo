package com.side.backend.demo;

import com.side.backend.demo.dto.login.req.UserLoginReq;
import com.side.backend.demo.dto.user.UserInfoDto;
import com.side.backend.demo.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.MessageSource;

import javax.annotation.PostConstruct;


@Slf4j
@RequiredArgsConstructor
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)    //	exclude  : 	security dependency delete
public class SideProjectApplication {

    private final MessageSource messageSource;
    private final UserInfoService userInfoService;

    public static void main(String[] args) {
        SpringApplication.run(SideProjectApplication.class, args);
    }

    @PostConstruct
    private void initUserSetting() {

        String userEmail = "shguddnr2@naver.com";
        String userPassword = "Test90000!@";

        UserInfoDto userInfoDto = UserInfoDto.builder()
                .firstName("노")
                .lastName("형욱")
                .userEmailAddress(userEmail)
                .userPassword(userPassword)
                .repeatPassword(userPassword)
                .build();

        userInfoService.registerUser(userInfoDto);
        UserLoginReq userLoginReq = UserLoginReq.builder()
                .userEmailAddress(userEmail)
                .userPassword(userPassword)
                .build();

        log.error("error = {}", userInfoService.userLogin(userLoginReq));

    }

}
