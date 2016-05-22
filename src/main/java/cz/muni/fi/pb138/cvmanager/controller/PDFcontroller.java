/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb138.cvmanager.controller;

import cz.muni.fi.pb138.cvmanager.service.PDFgenerator;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.xml.sax.SAXException;

/**
 *
 * @author david
 */
public class PDFcontroller extends BaseController {
    
     @Autowired
    private PDFgenerator pdfGenerator;
    
    // Don't know id necessary, if enough to take language from lang parameter or need to take it or set to Local in MessageSource
    //@Autowired
    //private MessageSource messageSource;
    
    @RequestMapping(value = "/auth/download", method = RequestMethod.GET)
    public ByteArrayOutputStream downloadPDF(@RequestParam("lang") String lang)
            throws TransformerException, ParserConfigurationException, IOException, SAXException
    {
        //uncomment the calling of method when login finished
        pdfGenerator.XmlToLatex(/*getPrincipalUsername()*/ "username", lang);
        ByteArrayOutputStream pdf = pdfGenerator.LatexToPdf();
        return pdf;
    }
}
