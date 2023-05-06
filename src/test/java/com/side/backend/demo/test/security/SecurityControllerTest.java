package com.side.backend.demo.test.security;

import com.side.backend.demo.test.security.base.SecurityControllerTestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class SecurityControllerTest extends SecurityControllerTestBase {


    @Nested
    @DisplayName("security_index_success_test")
    public class SecurityIndexSuccessTest {
        @Test
        void success() throws Exception {
            mockMvc.perform(get("/")
                            .with(httpBasic("user", "1234")))
                    .andExpect(status().isOk());
        }

    }

    @Nested
    @DisplayName("security_index_fail_test")
    public class SecurityIndexFailTest {
        @Test
        void isUnauthorized() throws Exception {
            mockMvc.perform(get("/"))
                    .andExpect(status().isUnauthorized());
        }
    }

    @Nested
    @DisplayName("security_permit_all_page_test")
    public class SecurityPermitAllPageTest {
        @Test
        void loginPage() throws Exception {
            mockMvc.perform(get("/login"))
                    .andExpect(status().isOk());
        }

        @Test
        void registerPage() throws Exception {
            mockMvc.perform(get("/register"))
                    .andExpect(status().isOk());
        }

    }


}
