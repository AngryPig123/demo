package com.side.backend.demo.service;

import com.side.backend.demo.dto.login.req.UserLoginReq;
import com.side.backend.demo.dto.user.UserInfoDto;
import com.side.backend.demo.entity.userentity.userinfo.UserInfo;
import com.side.backend.demo.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.Optional;

import static com.side.backend.demo.util.ModelMapperUtil.modelMapper;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserInfoServiceImpl implements UserInfoService {

    private final UserInfoRepository userInfoRepository;

    @Override
    public boolean registerUser(UserInfoDto userInfoDto) {

        String userEmailAddress = userInfoDto.getUserEmailAddress();

        if (!this.userEmailAddressExistCheck(userEmailAddress)) {
            UserInfo userInfo = modelMapper.map(userInfoDto, UserInfo.class);
            userInfoRepository.save(userInfo);
            log.info("register user success");
            return true;
        } else {
            log.error("register user reject");
            return false;
        }

    }

    @Override
    public boolean userLogin(UserLoginReq userLoginReq) {

        String userEmailAddress = userLoginReq.getUserEmailAddress();
        String userPassword = userLoginReq.getUserPassword();
        UserInfo entityUserInfo = userInfoRepository.findByUserEmailAddressAndUserPassword(userEmailAddress, userPassword);

        //  TODO Session에 데이터를 넣는다.
        if (entityUserInfo != null) {
            log.info("user login success");
            return true;
        } else {
            log.error("user login reject");
            return false;
        }
    }

    @Override
    public boolean userEmailAddressExistCheck(String userEmailAddress) {
        if (userInfoRepository.findByUserEmailAddress(userEmailAddress).isPresent()) {
            log.error("user email address exist reject");
            return true;
        } else {
            log.info("user email address exist success");
            return false;
        }
    }

    @Override
    public boolean deleteUser(UserLoginReq userLoginReq) {
        if (this.userLogin(userLoginReq)) {
            Optional<UserInfo> findUser = userInfoRepository.findByUserEmailAddress(userLoginReq.getUserEmailAddress());
            findUser.ifPresent(userInfoRepository::delete);
            log.info("delete user success");
            return true;
        } else {
            log.error("delete user success");
            return false;
        }
    }

}
