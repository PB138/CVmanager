package cz.muni.fi.pb138.cvmanager.service;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import cz.muni.fi.pb138.cvmanager.entity.CurriculumVitae;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by david on 9.6.16.
 */
@RunWith(DataProviderRunner.class)
public class PDFgeneratorTest {

    @Mock
    XmlService xmlService;

    @InjectMocks
    PDFgenerator pdfGenerator;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void xmlToLatexTest()
            throws ParserConfigurationException, IOException, SAXException, TransformerException
    {
        Mockito.when(xmlService.loadFromXml(Mockito.anyString()))
                .thenReturn(new CurriculumVitae());

        pdfGenerator.xmlToLatex("test", "sk");
        File file = new File("cvxml/test_cv.tex");
        assertTrue(file.exists());
    }

    @Test
    public void latexToPdfTest()
            throws IOException, InterruptedException
    {
        File f = new File("cvxml/test_cv.tex");
        if (f.exists()) {
            pdfGenerator.latexToPdf("test");
            File file = new File("cvxml/test_cv.pdf");
            assertTrue(file.exists());
        }
    }
}
