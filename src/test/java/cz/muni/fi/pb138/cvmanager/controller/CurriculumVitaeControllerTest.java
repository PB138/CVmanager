package cz.muni.fi.pb138.cvmanager.controller;

import cz.muni.fi.pb138.cvmanager.entity.CurriculumVitae;
import cz.muni.fi.pb138.cvmanager.service.XmlService;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


/**
 * Created by nfabian on 9.6.16.
 */
public class CurriculumVitaeControllerTest extends ControllerTestTemplate {

    @Mock
    XmlService xmlService;

    @InjectMocks
    CurriculumVitaeController curriculumVitaeController = new CurriculumVitaeController();

    @Before
    public void setup() {
        super.setup(curriculumVitaeController);
    }

    @Test
    public void indexTest() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    public void loadTest() throws Exception {
        Mockito.when(xmlService.loadFromXml(Mockito.anyString()))
                .thenReturn(new CurriculumVitae());

        mockMvc.perform(get("/auth")
                    .with(SecurityMockMvcRequestPostProcessors.user("user")))
                .andExpect(status().isOk())
                .andExpect(view().name("curriculumVitae"))
                .andExpect(model().attributeExists("cv"));
    }

    @Test
    public void editTest() throws Exception {
        Mockito.when(xmlService.loadFromXml(Mockito.anyString()))
                .thenReturn(new CurriculumVitae());

        mockMvc.perform(get("/auth/update")
                    .with(SecurityMockMvcRequestPostProcessors.user("user")))
                .andExpect(status().isOk())
                .andExpect(view().name("edit"))
                .andExpect(model().attributeExists("cv"));
    }
}
