/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb138.cvmanager.controller;

import org.springframework.stereotype.Controller;

/**
 *
 * @author david
 */
@Controller
public class BaseController {
    
    // *************************** Uncomment when authentication is done ************************************
//    protected String getPrincipalUsername() {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null) {
//            UserDetails userDetails = (UserDetails) auth.getPrincipal();
//        }
//        return userDetails.getUsername().isEmpty() ? null : userDetails.getUsername();
//    }
}
