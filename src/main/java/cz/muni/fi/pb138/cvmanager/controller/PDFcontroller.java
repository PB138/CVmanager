/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb138.cvmanager.controller;

import cz.muni.fi.pb138.cvmanager.service.PDFgenerator;
import java.io.InputStream;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 *
 * @author david
 */
@Controller
public class PDFcontroller extends BaseController {
    
     @Autowired
    private PDFgenerator pdfGenerator;
    
    // Don't know if enough to take language from lang parameter or need to take it or set to Local in MessageSource
    //@Autowired
    //private MessageSource messageSource;
    
//    @RequestMapping(value = "/auth/download", method = RequestMethod.GET)
//    public ByteArrayOutputStream downloadPDF(@RequestParam("language") String lang)
//            throws TransformerException, ParserConfigurationException, IOException, SAXException
//    {
//        //uncomment the calling of method when login finished
//        pdfGenerator.xmlToLatex(/*getPrincipalUsername()*/ "username", lang);
//        ByteArrayOutputStream pdf = pdfGenerator.latexToPdf();
//        return pdf;
//    }

    @RequestMapping(value = "/auth/download", method = RequestMethod.GET)
    public void downloadPDF(/*@RequestParam("language") String lang,*/ HttpServletResponse response)
    {
        try {
            //uncomment the calling of method when login finished
            pdfGenerator.xmlToLatex(/*getPrincipalUsername()*/ "david", /*lang*/ "sk");
            InputStream pdf = pdfGenerator.latexToPdf();

            response.setContentType("application/pdf");
            FileCopyUtils.copy(pdf, response.getOutputStream());
            response.flushBuffer();
        }
        catch(Exception ex){
            System.out.print(ex.toString());
        }
    }

}
