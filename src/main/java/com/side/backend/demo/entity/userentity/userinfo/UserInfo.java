package com.side.backend.demo.entity.userentity.userinfo;

import com.side.backend.demo.entity.common.date.UserDateEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Getter
@ToString
@NoArgsConstructor
@Table(name = "USER_BASE_INFO")
public class UserInfo extends UserDateEntity {

    //    회원가입 정보 테이블
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    //  seq number

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Email
    @Column(name = "user_email_address", unique = true, nullable = false)
    private String userEmailAddress;  //  아이디, email

    @Column(name = "user_password", nullable = false)
    private String userPassword;    //  비밀번호

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUserEmailAddress(String userEmailAddress) {
        this.userEmailAddress = userEmailAddress;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}