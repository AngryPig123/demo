package com.side.backend.demo.controller.register;


import com.side.backend.demo.dto.user.UserInfoDto;
import com.side.backend.demo.service.UserInfoService;
import com.side.backend.demo.util.message.MyMessageSource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
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

import static com.side.backend.demo.util.message.MyMessageSource.*;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/register")
public class UserRegisterController {

    private final UserInfoService userInfoService;
    private final MyMessageSource myMessageSource;
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

        boolean userEmailDuplicateValidate = userInfoService.registerUser(userInfoDto);

        if (!userInfoDto.isPasswordValid())
            bindingResult.rejectValue("passwordValid", "user.info.validation.password.repeat.message");

        if (!userEmailDuplicateValidate) {
            model.addAttribute("emailValid", myMessageSource.getMessage("user.info.validation.email.duplicate.message"));
        }

        if (bindingResult.hasErrors()) return "/common/register";

        model.addAttribute("status", "ok");
        return "redirect:/login";

    }

}
