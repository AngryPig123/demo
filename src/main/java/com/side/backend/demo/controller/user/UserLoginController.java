package com.side.backend.demo.controller.user;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/login")
public class UserLoginController {

    @GetMapping
    public String userLoginPage() {
        return "/common/login";
    }

}
