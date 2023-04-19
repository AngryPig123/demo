package com.side.backend.demo.controller.login;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.side.backend.demo.controller.vo.req.UserLoginReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {

//    private final UserLoginService userLoginService;
    private final ObjectMapper objectMapper;  //    qwer

    //    user login controller
    @ResponseBody
    @PostMapping("/user")
    public Object userLogin(@RequestBody @Validated UserLoginReq userLoginReq, BindingResult bindingResult) throws JsonProcessingException {

        if(bindingResult.hasErrors()){
            return JsonPath.parse(objectMapper.writeValueAsString(bindingResult.getAllErrors())).read("$..defaultMessage");
        }

        return userLoginReq;

    }

}
