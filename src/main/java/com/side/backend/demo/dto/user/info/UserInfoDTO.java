package com.side.backend.demo.dto.user.info;

import com.side.backend.demo.validator.password.ValidPassword;
import com.side.backend.demo.validator.phonenumber.ValidPhoneNumber;
import com.side.backend.demo.validator.userid.ValidUserId;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserInfoDTO {

    @ValidUserId
    private String userId;  //  아이디
    @ValidPassword
    private String userPassword;    //  비밀번호

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 12, message = "{user.validator.nickName}")
    private String nickName;    //  닉네임

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 12, message = "{user.validator.name}")
    private String userName;    //  유저이름

    @NotNull
    @NotEmpty
    @Size(min = 5, max = 6, message = "{user.validator.postalCode}")
    private String userPostalCode;  //  우편번호
    private String userDetailAddress;   //  상세주소

    @ValidPhoneNumber
    private String phoneNumber; //  핸드폰 번호

    @Email(message = "유요한 이메일 주소가 아닙니다.")
    private String email;

}