package com.side.backend.demo.entity.userentity.userinfo;


import javax.persistence.*;

@Entity
@Table(name="user_detail_info")
public class UserDetailInfo {

    //    회원가입 정보 테이블
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_detail_info_id")
    private Long id;


}

