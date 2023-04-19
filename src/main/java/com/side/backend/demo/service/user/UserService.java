package com.side.backend.demo.service.user;

import com.side.backend.demo.entity.userentity.userinfo.UserInfo;
import com.side.backend.demo.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserServiceImpl {
    private final UserEntityRepository userRepository;

    @Override
    public void saveUser(UserInfo userInfo) {
        userRepository.save(userInfo);
    }

}
