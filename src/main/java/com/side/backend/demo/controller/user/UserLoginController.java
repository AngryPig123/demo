package com.side.backend.demo.controller.user;


import com.side.backend.demo.dto.login.req.UserLoginReq;
import com.side.backend.demo.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/login")
public class UserLoginController {

    private final UserInfoService userInfoService;

    @GetMapping
    public String getUserLoginPage(Model model) {
        model.addAttribute("userLoginReq", new UserLoginReq());
        return "/common/login";
    }

    @PostMapping
    public String postUserLoginPage(
            @Validated @ModelAttribute("userLoginReq") UserLoginReq userLoginReq,
            BindingResult bindingResult,
            Model model
    ) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("bindingResult", bindingResult);
            return "/common/login";
        }
        if (userInfoService.userLogin(userLoginReq)) {
            return "redirect:/";
        } else {
            bindingResult.rejectValue("userPassword", "user.login.validation");
            model.addAttribute("bindingResult", bindingResult);
            return "/common/login";
        }
    }

}
