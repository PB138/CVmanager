/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb138.cvmanager.service;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchService;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;
import org.xml.sax.SAXException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;


/**
 *
 * @author david
 */ 
@Service
public class PDFgenerator {
    
    @Autowired
    private XmlService xmlService;
        
    
    public void XmlToLatex(String username, String lang) 
            throws TransformerConfigurationException, TransformerException, ParserConfigurationException, IOException, SAXException
    {
        TransformerFactory tf = TransformerFactory.newInstance();
        
        Transformer xsltProc = (lang.equals("sk")) ?
                tf.newTransformer(new StreamSource(new File("src/main/resources/xslt/XmlToLatex_sk.xsl")))
                : tf.newTransformer(new StreamSource(new File("src/main/resources/xslt/XmlToLatex_en.xsl")));
        DOMSource source = new DOMSource(xmlService.createDocument(xmlService.loadFromXml(username)));
        xsltProc.transform(source, new StreamResult(new File("cvxml/cv.tex")));
    }
    
    public InputStream LatexToPdf() throws IOException
    {
        //Runtime rt = Runtime.getRuntime();
        //rt.exec(new String[]{"pdflatex", "cv.tex", "--output-directory="});

        ProcessBuilder pb = new ProcessBuilder("pdflatex", "cv.tex", "--output-directory=");
        File file = new File("cvxml/");
        pb.directory(file);
        Process p = pb.start();

        File pdf = new File("cv.pdf");

        //dodělat checkování esi už je cv.pdf vytvořeno a už se do něj nezapisuje, pak až ho vrátit. Možná udělat ve druhým vlákně, aby neblokovalo zbytek aplikace.
//        WatchService watcher = FileSystems.getDefault().newWatchService();
//        Path dir = Paths.get("Path/To/Watched/Directory");
//        dir.register(watcher, ENTRY_CREATE, ENTRY_MODIFY);

        //dodělání tlačítka pro download do jsp
//        <button type = "button" class = "btn btn-default btn-lg ">
//            Default Button
//            </button>

        InputStream output = new FileInputStream(pdf);

        return output;
    }
}
