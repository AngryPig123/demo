package com.side.backend.demo.controller;

import com.side.backend.demo.entity.userentity.userinfo.UserInfo;
import com.side.backend.demo.service.user.UserService;
import com.side.backend.demo.service.user.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestController {
    private final UserService userService;


    @GetMapping("/index")
    public String getTestIndex(Model model) {

        model.addAttribute("userInfo", new UserInfo());
        model.addAttribute("title", "title");
        model.addAttribute("data", "test");
        return "/basic/index";
    }

    @PostMapping("/index")
    public String postTestIndex(
            @Validated @ModelAttribute("userInfo") UserInfo userInfo,
            BindingResult bindingResult,
            Model model) {

        model.addAttribute("userInfo", userInfo);
        
        if (bindingResult.hasErrors()) {
            return "/basic/index2";
        }

        userService.saveUser(userInfo);
        return "/basic/index2";
    }

}
