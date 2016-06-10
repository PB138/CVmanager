package cz.muni.fi.pb138.cvmanager.controller;

import cz.muni.fi.pb138.cvmanager.entity.Account;
import cz.muni.fi.pb138.cvmanager.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by zeman on 09-Jun-16.
 */
public class LoginControllerTest extends ControllerTestTemplate {

    @Mock
    AccountService accountService;

    @InjectMocks
    LoginController loginController = new LoginController();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(loginController)
                .apply(SecurityMockMvcConfigurers.springSecurity(filterChainProxy))
                .setViewResolvers(viewResolver)
                .build();
    }
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
        Mockito.doNothing().when(accountService).register(Mockito.any(Account.class));

        mockMvc.perform(post("/register").with(SecurityMockMvcRequestPostProcessors.csrf())
                .sessionAttr("account", new Account("asdf", "asdf")))
                .andExpect(status().isOk())
                .andExpect(view().name("login"));
    }
}
