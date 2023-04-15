package com.side.backend.demo.entity.userentity.userinfo;

import com.side.backend.demo.entity.userentity.UserDetailInfo;
import com.side.backend.demo.enumpackage.UserGrade;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Table(name = "USER_BASE_INFO")
public class UserInfo {

    //    회원가입 정보 테이블
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    //  seq number
    @Column(name = "user_id")
    private String userId;  //  아이디
    @Column(name = "user_password")
    private String userPassword;    //  비밀번호
    @Column(name = "nick_name")
    private String nickName;    //  닉네임
    @Column(name = "user_name")
    private String userName;    //  유저이름
    @Column(name = "user_postal_code")
    private String userPostalCode;  //  우편번호
    @Column(name = "user_detail_address")
    private String userDetailAddress;   //  상세주소
    @Column(name = "phone_number")
    private String phoneNumber; //  핸드폰 번호

    @Enumerated(EnumType.STRING)
    @Column(name = "user_grade")
    private UserGrade userGrade = UserGrade.NORMAL;


//    @OneToOne
//    @JoinColumn(name = "user_detail_info_id")
//    private UserDetailInfo userDetailInfo;

}