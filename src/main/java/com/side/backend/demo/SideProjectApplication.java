package com.side.backend.demo;

import com.side.backend.demo.dto.user.info.UserInfoDTO;
import com.side.backend.demo.entity.userentity.userinfo.UserInfo;
import com.side.backend.demo.repository.UserEntityRepository;
import com.side.backend.demo.util.ModelMapperUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.MessageSource;

import javax.annotation.PostConstruct;

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

        UserInfoDTO defaultUserInfo = UserInfoDTO.builder()
                .userId("test@naver.com")
                .userPassword("123NOHoo!!")
                .nickName("nickName")
                .userName("홍길동")
                .userPostalCode("111-212")
                .userDetailAddress("신림동")
                .phoneNumber("010-1234-1234")
                .build();

        UserInfo userInfo = ModelMapperUtil.comModelMapper(defaultUserInfo, UserInfo.class);

        repository.save(userInfo);

    }
}
