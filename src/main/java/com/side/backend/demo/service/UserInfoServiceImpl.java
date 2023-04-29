package com.side.backend.demo.service;

import com.side.backend.demo.dto.user.UserInfoDto;
import com.side.backend.demo.entity.userentity.userinfo.UserInfo;
import com.side.backend.demo.repository.UserInfoRepository;
import com.side.backend.demo.util.ModelMapperUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.side.backend.demo.util.ModelMapperUtil.modelMapper;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserInfoServiceImpl implements UserInfoService {

    private final UserInfoRepository userInfoRepository;

    @Override
    public void registerUser(UserInfoDto userInfoDto) {

        UserInfo userInfo = modelMapper.map(userInfoDto, UserInfo.class);
        userInfoRepository.save(userInfo);

    }
}
