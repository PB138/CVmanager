/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb138.cvmanager.service;

import java.io.*;
import java.nio.file.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchService;
import java.util.concurrent.TimeUnit;
import javax.xml.transform.Transformer;
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
        


    public void xmlToLatex(String username, String lang)
            throws TransformerException, ParserConfigurationException, IOException, SAXException
    {
        TransformerFactory tf = TransformerFactory.newInstance();

        Transformer xsltProc = (lang.equals("sk")) ?
                tf.newTransformer(new StreamSource(new File("src/main/resources/xslt/XmlToLatex_sk.xsl")))
                : tf.newTransformer(new StreamSource(new File("src/main/resources/xslt/XmlToLatex_en.xsl")));
        DOMSource source = new DOMSource(xmlService.createDocument(xmlService.loadFromXml(username)));
        xsltProc.transform(source, new StreamResult(new File("cvxml/" + username + "_cv.tex")));
    }


    public InputStream latexToPdf(String username)
            throws IOException, InterruptedException, NullPointerException
    {
        ProcessBuilder pb = new ProcessBuilder("pdflatex", username + "_cv.tex", "--output-directory=");
        File file = new File("cvxml/");
        pb.directory(file);
        Process p = pb.start();

        WatchService watcher = FileSystems.getDefault().newWatchService();
        Path dir = Paths.get("cvxml/");
        dir.register(watcher, ENTRY_CREATE, ENTRY_MODIFY);

        while(true) {
            // wait for a key to be available for 10 seconds
            WatchKey key = watcher.poll(10000L, TimeUnit.MILLISECONDS);
            if(key == null){
                break;
            }

            for (WatchEvent<?> event : key.pollEvents()) {
                // get event type
                WatchEvent.Kind<?> kind = event.kind();

                // get file name
                @SuppressWarnings("unchecked")
                WatchEvent<Path> ev = (WatchEvent<Path>) event;
                Path fileName = ev.context();

                System.out.println(kind.name() + ": " + fileName);
            }

            boolean valid = key.reset();
            if(!valid){
                break;
            }
        }

        System.out.println("end of cycle");


        File pdf = new File("cvxml/" + username + "_cv.pdf");

        return new FileInputStream(pdf);
    }
}
