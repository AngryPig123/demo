package com.side.backend.demo;

import com.side.backend.demo.entity.userentity.userinfo.UserInfo;
import com.side.backend.demo.enumpackage.UserGrade;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class TestClass {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static void main(String[] args) {

        UserInfo defaultUserInfo = UserInfo.builder()
                .userId("test@naver.com")
                .userPassword("123NOHoo!!")
                .nickName("nickName")
                .userName("홍길동")
                .userPostalCode("111-212")
                .userDetailAddress("신림동")
                .phoneNumber("010-1234-1234")
                .build();

        UserInfo userInfoDTO = modelMapper(defaultUserInfo, UserInfo.class);

        log.info("userInfoDTO = {}", userInfoDTO);
        log.info("defaultUserInfo = {}", defaultUserInfo);
        log.info("getUserGradeSet = {}", UserGrade.getUserGradeList());
        log.info("getUserGradeMap = {}", UserGrade.getUserGradeMap());
    }

    public static <T> T modelMapper(Object source, Class<T> destinationType) {
        return modelMapper.map(source, destinationType);
    }

}
