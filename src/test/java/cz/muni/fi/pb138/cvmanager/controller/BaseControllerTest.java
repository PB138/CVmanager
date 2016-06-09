package cz.muni.fi.pb138.cvmanager.controller;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by david on 9.6.16.
 */
public class BaseControllerTest {

    @InjectMocks
    BaseController baseController;

//    @Test
//    public void getPrincipalUsernameTest() {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        UserDetails userDetails = (UserDetails) auth.getPrincipal();
//        String userName = userDetails.getUsername();
//
//        assertEquals("user name not corret", userName, baseController.getPrincipalUsername());
//    }
}
