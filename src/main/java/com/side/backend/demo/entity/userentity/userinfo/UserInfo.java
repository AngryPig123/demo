package com.side.backend.demo.entity.userentity.userinfo;

import com.side.backend.demo.entity.common.date.UserDateEntity;
import com.side.backend.demo.enumpackage.UserGrade;
import com.side.backend.demo.validator.password.ValidPassword;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USER_BASE_INFO")
public class UserInfo extends UserDateEntity {

    //    회원가입 정보 테이블
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    //  seq number

    @Email
    @Column(name = "user_id", unique = true, nullable = false)
    private String userId;  //  아이디, email
    @ValidPassword
    @Column(name = "user_password", nullable = false)
    private String userPassword;    //  비밀번호
    @NotEmpty   //  TODO 비속어 필터 기능을 추가한다.
    @Column(name = "nick_name", nullable = false)
    private String nickName;    //  닉네임
    @NotEmpty
    @Column(name = "user_postal_code", nullable = false)
    private String userPostalCode;  //  우편번호
    @NotEmpty
    @Column(name = "user_detail_address", nullable = false)
    private String userDetailAddress;   //  상세주소

    //  TODO 핸드폰 본인 인증을 통해 해당 데이터를 받아온다.
    @NotEmpty
    @Column(name = "user_name", nullable = false)
    private String userName;    //  유저이름

    @NotEmpty
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber; //  핸드폰 번호

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setUserPostalCode(String userPostalCode) {
        this.userPostalCode = userPostalCode;
    }

    public void setUserDetailAddress(String userDetailAddress) {
        this.userDetailAddress = userDetailAddress;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //  TODO 사용자의 디테일 정보를 저장하고 관계지을 수 있는 설계를 추가한다.
    //    @OneToOne
    //    @JoinColumn(name = "user_detail_info_id")
    //    private UserDetailInfo userDetailInfo;

}