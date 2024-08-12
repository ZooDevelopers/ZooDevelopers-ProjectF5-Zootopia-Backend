package org.factoriaf5.zootopia.controllers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration

public class AuthControllerTest {
    @Autowired
    private WebApplicationContext context;

    MockMvc mockMvc;
    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .apply(SecurityMockMvcConfigurers.springSecurity())
                .build();
                
    }

    @Test
    @WithMockUser(username = "admin", roles={"ADMIN"})
    void testUsingAnnotationMockUser() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(get("/api/v1/login"))
                .andExpect(status().isAccepted())
                .andReturn()
                .getResponse();

                System.out.println(response.getContentAsString());

        assertThat(response.getContentAsString(), containsString("roles"));
        assertThat(response.getContentAsString(), containsString("Logged"));
        assertThat(response.getContentAsString(), 
                is("{\"roles\":\"ROLE_ADMIN\",\"message\":\"Logged\",\"username\":\"admin\"}"));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void testRoleUserCanAccessPathGetUsers() throws Exception {
        mockMvc.perform(get("/api/v1/login"))
                .andExpect(status().isAccepted())
                .andReturn()
                .getResponse();


}
}

