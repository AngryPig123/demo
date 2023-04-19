package com.side.backend.demo.validator.password;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {

    @Override
    public void initialize(ValidPassword constraintAnnotation) {
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        // 비밀번호에 대한 정규식 검사
        //  "비밀번호가 소문자, 대문자, 숫자, 특수문자를 모두 포함하며, 총 8자리 이상이어야 합니다."
        //  TODO : message properties에 넣는다.
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        return password.matches(regex);
    }

}
