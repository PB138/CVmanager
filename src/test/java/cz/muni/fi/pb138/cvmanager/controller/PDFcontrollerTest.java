package cz.muni.fi.pb138.cvmanager.controller;

import cz.muni.fi.pb138.cvmanager.service.PDFgenerator;
import cz.muni.fi.pb138.cvmanager.service.XmlService;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

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
    PDFcontroller pdfController;


    @Test
    public void downloadPDFTest() throws Exception {
        mockMvc.perform(get("/auth/download?l=en"))
                .andExpect(status().isOk());
    }
}
