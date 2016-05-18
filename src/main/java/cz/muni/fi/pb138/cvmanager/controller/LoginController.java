package cz.muni.fi.pb138.cvmanager.controller;

import cz.muni.fi.pb138.cvmanager.entity.Account;
import cz.muni.fi.pb138.cvmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {



 @Autowired
 private UserService userService;


    @RequestMapping("/login")
    public String login() {
        //model.addAttribute("current", "login");


        return "login";
    }


    @RequestMapping(value = "/register" , method = RequestMethod.GET)
    public String register(){
        return "register";
    }



    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPost(@ModelAttribute("account") Account account) {
        //model.addAttribute("current", "login");
        //userService.login(user.getUsername());


        return "login";
    }


//    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
//    public ModelAndView login() {
//        ModelAndView model = new ModelAndView();
//        model.setViewName("login");
//        return model;
//
//    }
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

//    @RequestMapping(value = {"/","/login"},method = RequestMethod.POST)
//    public ModelAndView loginPOST(HttpSession session, @ModelAttribute("user") User user){
//        ModelAndView model = new ModelAndView();
//        UserDao userDao = new UserDaoImpl();
//        if(userDao.getUser(user.getUsername()))
//        return model;
//    }

    @ModelAttribute("Account")
    public Account construct(){
        return new Account();
    }


    @RequestMapping(value = "/register" , method = RequestMethod.POST)
    public String registerPost(@ModelAttribute("user") Account account){

        userService.register(account);
        return "register";
    }
}
