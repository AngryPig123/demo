package com.side.backend.demo.service;

import com.side.backend.demo.dto.login.req.UserLoginReq;
import com.side.backend.demo.dto.user.UserInfoDto;

public interface UserInfoService {
    boolean registerUser(UserInfoDto userInfoDto);
    boolean userLogin(UserLoginReq userLoginReq);
}
