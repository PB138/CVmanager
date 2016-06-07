package cz.muni.fi.pb138.cvmanager.controller;

import cz.muni.fi.pb138.cvmanager.entity.Account;
import cz.muni.fi.pb138.cvmanager.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Autowired
    private AccountService accountService;


    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public String allUsers(Model model){
        model.addAttribute("users",accountService.findAll());
        return "users";
    }

    @RequestMapping(value={"/login" }, method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout) {
        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username or password!");

        }
        if (logout != null) {
            model.addObject("logout", "You have been logged out successfully");
        }

        model.setViewName("login");
        return model;
    }

    @RequestMapping(value = "/register" , method = RequestMethod.GET)
    public String register(){
        return "register";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }


    @ModelAttribute("Account")
    public Account construct(){
        return new Account();
    }


    @RequestMapping(value = "/register" , method = RequestMethod.POST)
    public ModelAndView registerPost(@ModelAttribute("account") Account account){

        ModelAndView model = new ModelAndView();
        if(!account.getPassword().equals(account.getRetypePassword())) {
            model.addObject("error","Passwords don't match!");
            model.setViewName("register");
            return  model;

        }else if(accountService.findOne(account.getUsername())!=null){
            model.addObject("error","Account with this name already exist!");
            model.setViewName("register");
            return  model;

        }
        else {
            accountService.register(account);
            model.addObject("success","Account created successfully!");
            model.setViewName("login");
            return model;
        }



    }
}
