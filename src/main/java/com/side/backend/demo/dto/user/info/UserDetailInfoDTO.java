package com.side.backend.demo.dto.user.info;


import javax.persistence.*;

@Entity
@Table(name="user_detail_info")
public class UserDetailInfoDTO {

    //    회원가입 정보 테이블
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_detail_info_id")
    private Long id;


}

