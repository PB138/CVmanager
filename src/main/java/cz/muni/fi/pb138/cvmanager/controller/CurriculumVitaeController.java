package cz.muni.fi.pb138.cvmanager.controller;
import cz.muni.fi.pb138.cvmanager.entity.CurriculumVitae;
import cz.muni.fi.pb138.cvmanager.service.XmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

/**
 * Created by nfabian on 2.5.16.
 */

@Controller
public class CurriculumVitaeController extends BaseController {

    @Autowired
    private XmlService xmlService;

    /**
     * Http Get request for "/auth"
     *
     * @return ModelAndView containing the the Curriculum Vitae Model object a "CurriculumVitae" JSP view
     * @throws IOException
     * @throws SAXException
     * @throws ParserConfigurationException
     */
    @RequestMapping(value = {"/auth"}, method = RequestMethod.GET)
    public ModelAndView load() throws IOException, SAXException, ParserConfigurationException {
        ModelAndView model = new ModelAndView();
        CurriculumVitae cv = xmlService.loadFromXml(getPrincipalUsername());
        model.addObject("cv", cv);
        model.setViewName("curriculumVitae");
        return model;
    }

    /**
     * Http Get request for "/auth/update"
     * @return ModelAndView , jsp view name = "edit" and adds cv object of current user to model
     * @throws IOException
     * @throws SAXException
     * @throws ParserConfigurationException
     */
    @RequestMapping(value = "/auth/update", method = RequestMethod.GET)
    public ModelAndView edit() throws IOException, SAXException, ParserConfigurationException {
        ModelAndView model = new ModelAndView();
        model.addObject("cv", xmlService.loadFromXml(getPrincipalUsername()));
        model.setViewName("edit");
        return model;
    }

    /**
     * Http Post request for "/auth/update"
     * Serialize cv object to xml file
     * @param cv object with all information from current cv
     * @return ModelAndView , redirects to /auth
     * @throws IOException
     * @throws TransformerException
     * @throws ParserConfigurationException
     */
    @RequestMapping(value = "/auth/update", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute("CurriculumVitae") CurriculumVitae cv)
            throws IOException, TransformerException, ParserConfigurationException {
        xmlService.serializeToXml(getPrincipalUsername(), cv);
        return new ModelAndView("redirect:/auth");
    }

    /**
     * Http Get request for "/" and "/index"
     * @return ModelAndView , jsp view with name "index"
     */
    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        return model;
    }
}
