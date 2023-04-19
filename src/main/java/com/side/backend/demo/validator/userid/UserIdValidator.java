package com.side.backend.demo.validator.userid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserIdValidator implements ConstraintValidator<ValidUserId, String> {

    @Override
    public void initialize(ValidUserId constraintAnnotation) {
    }

    @Override
    public boolean isValid(String userId, ConstraintValidatorContext context) {
        //  아이디 대한 정규식 검사
        //  4~12글자 사이의 아이디 검증, 영문+숫자, 아이디의 첫 시작은 영문이어야한다.
        //  TODO : message properties에 넣는다.
        String regex = "^[a-zA-Z0-9]{4,12}$";
        return userId.matches(regex);
    }

}
