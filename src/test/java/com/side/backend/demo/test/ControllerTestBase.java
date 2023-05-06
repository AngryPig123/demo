package com.side.backend.demo.test;

import com.side.backend.demo.dto.login.req.UserLoginReq;
import com.side.backend.demo.dto.user.UserInfoDto;
import com.side.backend.demo.service.UserInfoService;
import com.side.backend.demo.util.message.MyMessageSource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.context.MessageSource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@AutoConfigureMockMvc
public abstract class ControllerTestBase {

    @Autowired
    WebApplicationContext wac;

    @Autowired
    protected MyMessageSource myMessageSource;

    @Autowired
    protected MessageSource messageSource;

    @Autowired
    protected UserInfoService userInfoService;

    protected MockMvc mockMvc;

    //  init user case
    protected String initUserFirstName;
    protected String initUserLastName;
    protected String initUserEmail;
    protected String initUserPassword;

    //  not exist case
    protected String notExistUserEmail;
    protected String notExistUserPassword;

    //  missed regex case
    protected String missedRegexPassword;
    protected String missedRegexEmail;

    //  exist case
    protected String existEmail;


    @BeforeEach
    public void beforeEachSetup() {

        mockMvc = MockMvcBuilders
                .webAppContextSetup(wac)
//                .apply(springSecurity())
                .build();

        //  초기 설정
        initUserFirstName = myMessageSource.getMessage("init.first.name");
        initUserLastName = myMessageSource.getMessage("init.last.name");
        initUserEmail = myMessageSource.getMessage("init.email");
        initUserPassword = myMessageSource.getMessage("init.password");

        UserInfoDto initUser =
                UserInfoDto.builder()
                        .firstName(initUserFirstName)
                        .lastName(initUserLastName)
                        .userEmailAddress(initUserEmail)
                        .userPassword(initUserPassword)
                        .repeatPassword(initUserPassword)
                        .build();
        userInfoService.registerUser(initUser);


        //  검증에 맞지 않는 case
        missedRegexEmail = myMessageSource.getMessage("init.missed.regex.email");
        missedRegexPassword = myMessageSource.getMessage("init.missed.regex.password");

        //  포함되지 않는 case
        notExistUserEmail = myMessageSource.getMessage("init.not.exist.email");
//        notExistUserPassword = myMessageSource.getMessage("init.not.exist.email");

        //  중복되는 case
        existEmail = myMessageSource.getMessage("init.email");
    }

    @AfterEach
    public void afterEachSetup() {
        UserLoginReq userLoginReq = UserLoginReq.builder()
                .userEmailAddress(initUserEmail)
                .userPassword(initUserPassword)
                .build();
        userInfoService.deleteUser(userLoginReq);
    }

}
