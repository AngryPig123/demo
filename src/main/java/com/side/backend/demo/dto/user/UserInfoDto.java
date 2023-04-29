package com.side.backend.demo.dto.user;

import com.side.backend.demo.service.common.CommonUserValidService;
import lombok.*;

import javax.validation.constraints.*;
import java.util.Optional;

@ToString
@Setter
@Getter
@NoArgsConstructor
public class UserInfoDto {

    @Size(min = 1, max = 20, message = "{user.info.validation.firstname.message}")
    private String firstName;

    @Size(min = 1, max = 20, message = "{user.info.validation.lastname.message}")
    private String lastName;

    @NotEmpty(message = "{user.info.validation.email.message}")
    @Email(message = "{user.info.validation.email.message}")
    private String userEmailAddress;  //  아이디, email

    @Size(min = 8, max = 20, message = "{user.info.validation.password.size.message}")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,20}$",
            message = "{user.info.validation.password.regex.message}"
    )
    private String userPassword; //  비밀번호

}