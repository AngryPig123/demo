package com.side.backend.demo.validator.userid;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UserIdValidator.class) // 사용할 Validator 클래스
@Target({ElementType.FIELD, ElementType.PARAMETER}) // 어노테이션 적용 대상
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidUserId {
    String message() default "{user.validator.id}"; // 유효성 검사 실패 시 메시지
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
