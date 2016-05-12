package cz.muni.fi.pb138.cvmanager.controller;
import cz.muni.fi.pb138.cvmanager.entity.CurriculumVitae;
import cz.muni.fi.pb138.cvmanager.service.XmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by nfabian on 2.5.16.
 */

@Controller
public class CurriculumVitaeController {

    @Autowired
    private XmlService xmlService;

    @RequestMapping(value = "/auth", method = RequestMethod.GET)
    public ModelAndView load() {
        ModelAndView model = new ModelAndView();

        // *************************** Uncomment when authentication is done ************************************
        //model.addObject("cv", xmlService.loadFromXml(getPrincipalUsername()));

        //model.addObject("cv", xmlService.loadFromXml("username"));
        model.setViewName("curriculumVitae");
        return model;
    }

    @RequestMapping(value = "/auth/update", method = RequestMethod.GET)
    public ModelAndView update() {
        ModelAndView model = new ModelAndView();

        // *************************** Uncomment when authentication is done ************************************
        //model.addObject("cv", xmlService.loadFromXml(getPrincipalUsername()));

        model.setViewName("update");
        return model;
    }

    @RequestMapping(value = "/auth/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("CurriculumVitae") CurriculumVitae cv) {
        ModelAndView model = new ModelAndView();

        // *************************** Uncomment when authentication is done ************************************
        //xmlService.serializeToXml(xmlService.loadFromXml(getPrincipalUsername()), cv);

        return "redirect:/auth";
    }

    // *************************** Uncomment when authentication is done ************************************
//    private String getPrincipalUsername() {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null) {
//            UserDetails userDetails = (UserDetails) auth.getPrincipal();
//        }
//        return userDetails.getUsername().isEmpty() ? null : userDetails.getUsername();
//    }
}
