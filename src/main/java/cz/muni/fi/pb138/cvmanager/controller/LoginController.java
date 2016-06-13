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
public class LoginController extends BaseController {

    @Autowired
    private AccountService accountService;


    /**
     * Http Get request for "/users"
     *
     * @param model model that contains all users
     * @return jsp view with name "users"
     */
    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public String allUsers(Model model){
        model.addAttribute("users",accountService.findAll());
        return "users";
    }

    /**
     * Http Get request for "/login"
     * @param error contains error message after authentication went wrong
     * @param logout message after logout
     * @return ModelAndView with jsp view with name "login" and model with possible error parameter and logout parameter
     */
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

    /**
     * Http Get request for "/register"
     * @return jsp view with name "register"
     */
    @RequestMapping(value = "/register" , method = RequestMethod.GET)
    public String register(){
        return "register";
    }

    /**
     * Http Get request for "/logout"
     * and signs out the current user with spring security
     * @param request HttpServlet request
     * @param response HttpServlet response
     * @return jsp view with name "login" and parameter logout
     */
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }


    /**
     * Constructs new Account Object used in spring security login post request
     * @return new Account Object
     */
    @ModelAttribute("Account")
    public Account construct(){
        return new Account();
    }


    /**
     * Http Post request for "/register"
     * Registers new User with given information in account object
     * Checks if username is taken
     * Checks if password and username are correct
     * @param account with information about user
     * @return ModelAndView with view if everything during registration went all right then jsp view name "login"
     * else "register
     * it adds parameters to model with messages
     */
    @RequestMapping(value = "/register" , method = RequestMethod.POST)
    public ModelAndView registerPost(@ModelAttribute("account") Account account) {

        ModelAndView model = new ModelAndView();
        if (account.getUsername() == null || account.getUsername().equals("")) {
            model.addObject("error","UsernameEmpty");
            model.setViewName("register");
            return  model;
        }
        if (account.getPassword() == null || account.getPassword().equals("")) {
            model.addObject("error","PasswordEmpty");
            model.setViewName("register");
            return  model;
        }
        if (account.getRetypePassword() == null || account.getRetypePassword().equals("")) {
            model.addObject("error","RetypePasswordEmpty");
            model.setViewName("register");
            return  model;
        }

        if (!account.getPassword().equals(account.getRetypePassword())) {
            model.addObject("error","PasswordMatchError");
            model.setViewName("register");
            return  model;

        }
        if (accountService.login(account.getUsername()) != null) {
            model.addObject("error","SameAccount");
            model.setViewName("register");
            return  model;

        }

        accountService.register(account);
        model.addObject("success","AccountSuccess");
        model.setViewName("login");
        return model;

    }
}
