package cz.muni.fi.pb138.cvmanager.service;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
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

    PDFgenerator pdfGenerator;

    @Before
    public void initialize() {
        pdfGenerator = new PDFgenerator();
    }

    @Test
    public void xmlToLatexTest()
            throws ParserConfigurationException, IOException, SAXException, TransformerException
    {
        pdfGenerator.xmlToLatex("test", "sk");
        File file = new File("cvxml/test_cv.tex");
        assertTrue(file.exists());
//        file.delete();
//
//        pdfGenerator.xmlToLatex("test", "en");
//        file = new File("cvxml/test_cv.tex");
//        assertTrue(file.exists());
    }

//    @Test
//    public void latexToPdfTest()
//            throws IOException, InterruptedException
//    {
//        pdfGenerator.latexToPdf("test");
//        File file = new File("cvxml/test_cv.pdf");
//        assertTrue(file.exists());
//    }
}
