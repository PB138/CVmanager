package cz.muni.fi.pb138.cvmanager.controller;

import cz.muni.fi.pb138.cvmanager.entity.Account;
import org.junit.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by zeman on 09-Jun-16.
 */
public class LoginControllerTest extends ControllerTestTemplate {


    @Test
    public void loginOkTest() throws Exception {
        mockMvc.perform(get("/login"))
                .andExpect(status().isOk())
                .andExpect(view().name("login"));
    }
    @Test
    public void loginErrorTest() throws Exception{
        mockMvc.perform(get("/login").param("error","error"))
                .andExpect(status().isOk())
                .andExpect(view().name("login"))
                .andExpect(model().attribute("error", "Invalid username or password!"));
    }
    @Test
    public void loginLogoutTest() throws Exception {
        mockMvc.perform(get("/login").param("logout", "logout"))
                .andExpect(status().isOk())
                .andExpect(view().name("login"))
                .andExpect(model().attribute("logout", "You have been logged out successfully"));
    }

    @Test
    public void registerGetTest() throws Exception {
        mockMvc.perform(get("/register"))
                .andExpect(status().isOk())
                .andExpect(view().name("register"));
    }

    @Test
    public void registerPostOkTest() throws Exception {
        Account acc = new Account("kappa","kappa");
        mockMvc.perform(post("/register")
                    //.param("account",)
                    )
                .andExpect(status().isOk())
                .andExpect(view().name("login"));
    }
}
