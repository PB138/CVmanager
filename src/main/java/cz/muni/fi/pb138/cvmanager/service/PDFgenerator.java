/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb138.cvmanager.service;

import java.io.File;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import cz.muni.fi.pb138.cvmanager.service.XmlService;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;
import org.xml.sax.SAXException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


/**
 *
 * @author david
 */ 
@Service
public class PDFgenerator {
    
    @Autowired
    private XmlService xmlService;
        
    
    public void xmlToLatex(String username)throws TransformerConfigurationException, TransformerException,
            ParserConfigurationException, IOException, SAXException
    {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer xsltProc = tf.newTransformer(new StreamSource(new File("XmlToLatex.xsl")));
        DOMSource source = new DOMSource(xmlService.createDocument(xmlService.loadFromXml(username)));
        xsltProc.transform(source, new StreamResult(new File("CV.tex")));    
    }
    
    public void latexToPdf() throws IOException
    {
        Runtime rt = Runtime.getRuntime();
        rt.exec(new String[]{"pdflatex", "cv.tex", "--output-directory="});
    }
}
