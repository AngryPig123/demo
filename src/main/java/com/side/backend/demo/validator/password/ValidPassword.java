package com.side.backend.demo.validator.password;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordValidator.class) // 사용할 Validator 클래스
@Target({ElementType.FIELD, ElementType.PARAMETER}) // 어노테이션 적용 대상
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPassword {
    String message() default "비밀번호가 소문자, 대문자, 숫자, 특수문자를 모두 포함하며, 총 8자리 이상이어야 합니다."; // 유효성 검사 실패 시 메시지
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
