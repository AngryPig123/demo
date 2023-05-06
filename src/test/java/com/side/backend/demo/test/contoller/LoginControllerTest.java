package com.side.backend.demo.test.contoller;

import com.side.backend.demo.test.ControllerTestBase;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@SpringBootTest
public class LoginControllerTest extends ControllerTestBase {

    @Nested
    @DisplayName("loginSuccess")
    public class LoginSuccessTest {
        @Test
        void loginSuccess() throws Exception {
            MvcResult mvcResult = mockMvc.perform(
                            post("/login")
                                    .param("userEmailAddress", initUserEmail)
                                    .param("userPassword", initUserPassword)
                    )
                    .andExpect(status().isOk())
                    .andReturn();
            ModelAndView modelAndView = mvcResult.getModelAndView();
            String viewName = modelAndView != null ? modelAndView.getViewName() : null;
            Assertions.assertEquals(viewName, "index", "fail");
            Assertions.assertNotEquals(viewName, "nomatchViewName", "fail");
        }

    }

    @Nested
    @DisplayName("loginFail")
    public class LoginFailTest {

        @Test
        void emailAndPasswordMissedValidate() throws Exception {
            MvcResult mvcResult = mockMvc.perform(
                            post("/login")
                                    .param("userEmailAddress", missedRegexEmail)
                                    .param("userPassword", missedRegexPassword)
                    )
                    .andExpect(status().isOk())
                    .andReturn();

            ModelAndView modelAndView = mvcResult.getModelAndView();
            String viewName = modelAndView != null ? modelAndView.getViewName() : null;

            assert modelAndView != null;
            BindingResult bindingResult = (BindingResult) modelAndView.getModel().get("bindingResult");
            List<ObjectError> errors = bindingResult.getAllErrors();
            Assertions.assertTrue(bindingResult.hasErrors(), "binding result parse fail");
            Assertions.assertEquals(errors.size(), 2, "binding result get errors size fail");
            /*
                        Assertions.assertEquals(
                                errors.get(0).getDefaultMessage(),
                                myMessageSource.getMessage("user.login.validation"),
                                "get default message fail"
                        );
            */
            Assertions.assertEquals(viewName, "/common/login", "fail");

        }   //  이메일이 없을때

        @Test
        void emailNotExist() throws Exception {
            MvcResult mvcResult = mockMvc.perform(
                            post("/login")
                                    .param("userEmailAddress", notExistUserEmail)
                                    .param("userPassword", initUserPassword)
                    )
                    .andExpect(status().isOk())
                    .andReturn();

            ModelAndView modelAndView = mvcResult.getModelAndView();
            String viewName = modelAndView != null ? modelAndView.getViewName() : null;

            assert modelAndView != null;
            BindingResult bindingResult = (BindingResult) modelAndView.getModel().get("bindingResult");
            List<ObjectError> errors = bindingResult.getAllErrors();
            Assertions.assertTrue(bindingResult.hasErrors(), "binding result parse fail");
            Assertions.assertEquals(errors.size(), 1, "binding result get errors size fail");
            /*
                        Assertions.assertEquals(
                                errors.get(0).getDefaultMessage(),
                                myMessageSource.getMessage("user.login.validation"),
                                "get default message fail"
                        );
            */
            Assertions.assertEquals(viewName, "/common/login", "fail");

        }   //  이메일이 없을때

        @Test
        void emailRegexMissed() throws Exception {
            MvcResult mvcResult = mockMvc.perform(
                            post("/login")
                                    .param("userEmailAddress", missedRegexEmail)
                                    .param("userPassword", initUserPassword)
                    )
                    .andExpect(status().isOk())
                    .andReturn();

            ModelAndView modelAndView = mvcResult.getModelAndView();
            String viewName = modelAndView != null ? modelAndView.getViewName() : null;

            assert modelAndView != null;
            BindingResult bindingResult = (BindingResult) modelAndView.getModel().get("bindingResult");
            List<ObjectError> errors = bindingResult.getAllErrors();
            Assertions.assertTrue(bindingResult.hasErrors(), "binding result parse fail");
            Assertions.assertEquals(errors.size(), 1, "binding result get errors size fail");
            /*
                        Assertions.assertEquals(
                                errors.get(0).getDefaultMessage(),
                                myMessageSource.getMessage("user.login.validation"),
                                "get default message fail"
                        );
            */
            Assertions.assertEquals(viewName, "/common/login", "fail");

        }   //  이메일 형식이 잘못되었을때

        @Test
        void passwordMissed() throws Exception {
            MvcResult mvcResult = mockMvc.perform(
                            post("/login")
                                    .param("userEmailAddress", missedRegexEmail)
                                    .param("userPassword", notExistUserPassword)
                    )
                    .andExpect(status().isOk())
                    .andReturn();

            ModelAndView modelAndView = mvcResult.getModelAndView();
            String viewName = modelAndView != null ? modelAndView.getViewName() : null;

            assert modelAndView != null;
            BindingResult bindingResult = (BindingResult) modelAndView.getModel().get("bindingResult");
            List<ObjectError> errors = bindingResult.getAllErrors();
            Assertions.assertTrue(bindingResult.hasErrors(), "binding result parse fail");
            Assertions.assertEquals(errors.size(), 1, "binding result get errors size fail");
            /*
                        Assertions.assertEquals(
                                errors.get(0).getDefaultMessage(),
                                myMessageSource.getMessage("user.login.validation"),
                                "get default message fail"
                        );
            */
            Assertions.assertEquals(viewName, "/common/login", "fail");


        }   //  패스워드가 안맞을때

        @Test
        void passwordRegexMissed() throws Exception {
            MvcResult mvcResult = mockMvc.perform(
                            post("/login")
                                    .param("userEmailAddress", initUserEmail)
                                    .param("userPassword", missedRegexPassword)
                    )
                    .andExpect(status().isOk())
                    .andReturn();

            ModelAndView modelAndView = mvcResult.getModelAndView();
            String viewName = modelAndView != null ? modelAndView.getViewName() : null;

            assert modelAndView != null;
            BindingResult bindingResult = (BindingResult) modelAndView.getModel().get("bindingResult");
            List<ObjectError> errors = bindingResult.getAllErrors();
            Assertions.assertTrue(bindingResult.hasErrors(), "binding result parse fail");
            Assertions.assertEquals(errors.size(), 1, "binding result get errors size fail");
            /*
                        Assertions.assertEquals(
                                errors.get(0).getDefaultMessage(),
                                myMessageSource.getMessage("user.login.validation"),
                                "get default message fail"
                        );
            */
            Assertions.assertEquals(viewName, "/common/login", "fail");

        }   //  패스워드 형식이 잘못되었을때

    }


}
