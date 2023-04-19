package com.side.backend.demo.controller.vo.req;

import com.side.backend.demo.validator.password.ValidPassword;
import com.side.backend.demo.validator.userid.ValidUserId;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginReq {

    @ValidUserId
    private String userId;
    @ValidPassword
    private String userPassword;

}
