package com.side.backend.demo.repository;

import com.side.backend.demo.entity.userentity.userinfo.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepository extends JpaRepository<UserInfo, Long> {

}
