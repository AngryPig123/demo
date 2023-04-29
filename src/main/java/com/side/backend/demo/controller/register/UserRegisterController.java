package com.side.backend.demo.controller.register;


import com.side.backend.demo.dto.user.UserInfoDto;
import com.side.backend.demo.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/register")
public class UserRegisterController {

    private final UserInfoService userInfoService;

    @GetMapping
    public String getUserRegisterPage(Model model) {
        model.addAttribute("userInfoDto", new UserInfoDto());
        return "/common/register";
    }

    @PostMapping
    public String postUserRegisterPage(
            @Validated @ModelAttribute("userInfoDto") UserInfoDto userInfoDto,
            BindingResult bindingResult,
            Model model
    ) {

        if (!userInfoDto.isPasswordValid())
            bindingResult.rejectValue("passwordValid", "user.info.validation.password.repeat.message");

        if (bindingResult.hasErrors()) return "/common/register";

        if (userInfoService.registerUser(userInfoDto)) {
            model.addAttribute("status", "ok");
        } else {
            model.addAttribute("status", "fail");
        }

        return "redirect:/login";

    }

}
