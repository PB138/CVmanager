package cz.muni.fi.pb138.cvmanager.controller;

import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * Created by nfabian on 9.6.16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring-modules.xml"})
public abstract class ControllerTestTemplate {

    @Autowired
    FilterChainProxy filterChainProxy;

    protected MockMvc mockMvc;

    public void setup(BaseController controller) {
        MockitoAnnotations.initMocks(this);

        this.mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .apply(SecurityMockMvcConfigurers.springSecurity(filterChainProxy))
                .build();
    }
}
