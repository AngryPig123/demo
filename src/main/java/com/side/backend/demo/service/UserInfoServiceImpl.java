package com.side.backend.demo.service;

import com.side.backend.demo.dto.login.req.UserLoginReq;
import com.side.backend.demo.dto.user.UserInfoDto;
import com.side.backend.demo.entity.userentity.userinfo.UserInfo;
import com.side.backend.demo.repository.UserInfoRepository;
import com.side.backend.demo.util.ModelMapperUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.side.backend.demo.util.ModelMapperUtil.modelMapper;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserInfoServiceImpl implements UserInfoService {

    private final UserInfoRepository userInfoRepository;

    @Override
    public boolean registerUser(UserInfoDto userInfoDto) {

        try {
            UserInfo userInfo = modelMapper.map(userInfoDto, UserInfo.class);
            userInfoRepository.save(userInfo);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean userLogin(UserLoginReq userLoginReq) {

        String userEmailAddress = userLoginReq.getUserEmailAddress();
        String userPassword = userLoginReq.getUserPassword();
        UserInfo entityUserInfo = userInfoRepository.findByUserEmailAddressAndUserPassword(userEmailAddress, userPassword);

        if (entityUserInfo != null) {
            UserInfoDto findByUser = modelMapper.map(entityUserInfo, UserInfoDto.class);

            //  TODO Session에 데이터를 넣는다.
            log.info("findByUser = {}", findByUser);

            return true;
        } else {
            return false;
        }

    }

}
