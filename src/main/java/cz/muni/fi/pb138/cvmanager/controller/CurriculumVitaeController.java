package cz.muni.fi.pb138.cvmanager.controller;
import cz.muni.fi.pb138.cvmanager.entity.CurriculumVitae;
import cz.muni.fi.pb138.cvmanager.service.XmlService;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.transform.TransformerException;
import java.io.IOException;

/**
 * Created by nfabian on 2.5.16.
 */

@Controller
public class CurriculumVitaeController {

    @Autowired
    private XmlService xmlService;

    @RequestMapping(value = {"/auth"}, method = RequestMethod.GET)
    public ModelAndView load() throws IOException, SAXException, ParserConfigurationException {
        ModelAndView model = new ModelAndView();
        CurriculumVitae cv = xmlService.loadFromXml(getPrincipalUsername());
        model.addObject("cv", cv);
        model.setViewName("curriculumVitae");
        return model;
    }

    @RequestMapping(value = "/auth/update", method = RequestMethod.GET)
    public ModelAndView update() throws IOException, SAXException, ParserConfigurationException {
        ModelAndView model = new ModelAndView();
        model.addObject("cv", xmlService.loadFromXml(getPrincipalUsername()));
        model.setViewName("update");
        return model;
    }

    @RequestMapping(value = "/auth/update", method = RequestMethod.POST)
    public ModelAndView update(@ModelAttribute("CurriculumVitae") CurriculumVitae cv)
            throws IOException, TransformerException, ParserConfigurationException {
        ModelAndView model = new ModelAndView();
        xmlService.serializeToXml(getPrincipalUsername(), cv);
        model.addObject("cv", cv);
        model.setViewName("curriculumVitae");
        return model;
    }

    private String getPrincipalUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        return userDetails.getUsername();
    }

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public ModelAndView main() {
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        return model;
    }
}
