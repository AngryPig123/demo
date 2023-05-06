package com.side.backend.demo.util;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class BindingResultUtil {

    public static Map<String, String> getBindingResultErrorMap(BindingResult bindingResult) {
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        Map<String, String> errorMap = new HashMap<>();
        fieldErrors.forEach((item) -> {
            errorMap.put(item.getField() + "Validate", item.getDefaultMessage());
        });
        return errorMap;
    }

}
