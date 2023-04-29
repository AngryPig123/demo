package com.side.backend.demo.dto.login.req;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class UserLoginReq {

    @NotEmpty(message = "{user.info.validation.email.message}")
    @Email(message = "{user.info.validation.email.message}")
    private String userEmailAddress;

    @Size(min = 8, max = 20, message = "{user.info.validation.password.size.message}")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,20}$",
            message = "{user.info.validation.password.regex.message}"
    )
    private String userPassword;

}
