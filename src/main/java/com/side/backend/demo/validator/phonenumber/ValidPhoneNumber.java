package com.side.backend.demo.validator.phonenumber;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PhoneNumberValidator.class) // 사용할 Validator 클래스
@Target({ElementType.FIELD, ElementType.PARAMETER}) // 어노테이션 적용 대상
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPhoneNumber {
    String message() default "{user.validator.phoneNumber}"; // 유효성 검사 실패 시 메시지
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
