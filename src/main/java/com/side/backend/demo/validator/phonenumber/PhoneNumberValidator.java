package com.side.backend.demo.validator.phonenumber;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, String> {

    @Override
    public void initialize(ValidPhoneNumber constraintAnnotation) {
    }

    @Override
    public boolean isValid(String userId, ConstraintValidatorContext context) {
        //  핸드폰 번호 검증
        //  010- 으로 시작되는 핸드폰 번호 검증 정규식
        //  TODO : message properties에 넣는다.
        String regex = "^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$";
        return userId.matches(regex);
    }

}
