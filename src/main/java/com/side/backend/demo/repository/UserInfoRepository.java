package com.side.backend.demo.repository;

import com.side.backend.demo.entity.userentity.userinfo.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

    UserInfo findByUserEmailAddressAndUserPassword(String userEmailAddress, String userPassword);
    Optional<UserInfo> findByUserEmailAddress(String email);

}
