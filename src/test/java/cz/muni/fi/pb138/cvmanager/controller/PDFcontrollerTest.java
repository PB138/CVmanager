package cz.muni.fi.pb138.cvmanager.controller;

import cz.muni.fi.pb138.cvmanager.service.PDFgenerator;
import cz.muni.fi.pb138.cvmanager.service.XmlService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;

import javax.xml.ws.Response;

import java.io.File;
import java.io.FileInputStream;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


/**
 * Created by david on 9.6.16.
 */
public class PDFcontrollerTest extends ControllerTestTemplate  {

    @Mock
    PDFgenerator pdfGenerator;

    @InjectMocks
    PDFcontroller pdfController = new PDFcontroller();

    @Before
    public void setup() {
        super.setup(pdfController);
    }


    @Test
    public void downloadPDFTest() throws Exception {
        Mockito.when(pdfGenerator.latexToPdf(Mockito.anyString()))
                .thenReturn(new FileInputStream(new File("cvxml/test_cv.pdf")));

        MockHttpServletResponse response = mockMvc
                .perform(get("/auth/download?l=en")
                        .with(SecurityMockMvcRequestPostProcessors.user("user")))
                .andExpect(status().isOk())
                .andReturn().getResponse();

        Assert.assertEquals("Content is not application/pdf", "application/pdf", response.getContentType());
    }
}
