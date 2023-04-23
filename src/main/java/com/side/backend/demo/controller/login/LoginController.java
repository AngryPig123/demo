package com.side.backend.demo.controller.login;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.side.backend.demo.dto.user.login.req.UserLoginReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.side.backend.demo.util.BindingResultUtil.getBindingResultErrorMap;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {

    //    private final UserLoginService userLoginService;
    private final ObjectMapper objectMapper;  //    qwer

    @GetMapping
    public String getUserLoginPage(Model model) {
        model.addAttribute("userLoginReq", new UserLoginReq());
        return "/common/login";
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Object> userLogin(
            @Validated @ModelAttribute("userLoginReq") UserLoginReq userLoginReq,
            BindingResult bindingResult
    ) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(getBindingResultErrorMap(bindingResult));
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userLoginReq);
    }

}
