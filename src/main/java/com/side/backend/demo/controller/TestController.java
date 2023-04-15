package com.side.backend.demo.controller;

import com.side.backend.demo.entity.userentity.userinfo.UserInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestController {

    @GetMapping("/index")
    public String getTestIndex(Model model) {

        model.addAttribute("userInfo", new UserInfo());
        model.addAttribute("title", "title");
        model.addAttribute("data", "test");
        return "/basic/index";
    }

    @PostMapping("/index")
    public String postTestIndex(
            @ModelAttribute("userInfo") UserInfo userInfo,
            Model model) {
        model.addAttribute("userInfo", userInfo);
        return "/basic/index2";
    }

}
