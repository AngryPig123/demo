package com.side.backend.demo;

import com.side.backend.demo.entity.userentity.userinfo.UserInfo;
import com.side.backend.demo.enumpackage.UserGrade;
import com.side.backend.demo.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.MessageSource;

import javax.annotation.PostConstruct;

import java.util.Locale;

import static com.side.backend.demo.util.ConsoleTextColor.*;


@Slf4j
@RequiredArgsConstructor
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)    //	exclude  : 	security dependency delete
public class SideProjectApplication {

    private final UserEntityRepository repository;
    private final MessageSource messageSource;

    public static void main(String[] args) {
        SpringApplication.run(SideProjectApplication.class, args);
    }


    @PostConstruct
    public void init() {
        //  해당 코드는 validator 를 거치지 않는다.

       /* log.info(COLOR1 + "init user info setting");
        UserInfo defaultUserInfo = UserInfo.builder()
                .userId("test@naver.com")
                .userPassword("123NOHoo!!")
                .nickName("nickName")
                .userName("홍길동")
                .userPostalCode("111-212")
                .userDetailAddress("신림동")
                .phoneNumber("010-1234-1234")
                .userGrade(UserGrade.NORMAL)
                .build();
        log.info(COLOR1 + "user info data setting = {}" + RESET, defaultUserInfo);

        log.info(COLOR2+"spring data jpa insert start");
        repository.save(defaultUserInfo);
        log.info(COLOR2+"spring data jpa insert end"+RESET);*/

//        System.err.println(messageSource.getMessage("test",null, Locale.KOREAN));

    }
}
