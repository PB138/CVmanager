/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb138.cvmanager.controller;

import cz.muni.fi.pb138.cvmanager.service.PDFgenerator;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 *
 * @author david
 */
@Controller
public class PDFcontroller extends BaseController {
    
     @Autowired
    private PDFgenerator pdfGenerator;


    @RequestMapping(value = "/auth/download", method = RequestMethod.GET)
    public void downloadPDF(@RequestParam("l") String lang, HttpServletResponse response)
    {
        try {
            //uncomment the calling of method when login finished
            pdfGenerator.xmlToLatex(getPrincipalUsername(), lang);
            InputStream pdf = pdfGenerator.latexToPdf(getPrincipalUsername());

            response.setContentType("application/pdf");
            FileCopyUtils.copy(pdf, response.getOutputStream());
            response.flushBuffer();
        }
        catch(Exception ex){
            System.out.print(ex.toString());
            try {
                PrintWriter out = response.getWriter();
                out.println("Sorry, generating of CV to PDF failed");
                out.close();
            }
            catch(Exception e){
                System.out.print("not able to print on web site");
            }
        }
    }

}
