package com.application.controller;

import com.application.configuration.ErrorMessage;
import com.application.configuration.PageHTML;
import com.application.configuration.PageURL;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @RequestMapping(value = PageURL.login, method = RequestMethod.GET)
    public String login() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!(auth instanceof AnonymousAuthenticationToken)) {
            return "redirect:"+ PageURL.home;
        }
        return PageHTML.login;
    }

    @RequestMapping(value =  PageURL.loginError, method = RequestMethod.GET)
    public String login(HttpServletRequest request, Model model) {
        model.addAttribute("errorMessage", ErrorMessage.badCredential);
        return PageHTML.login;
    }

    @RequestMapping(value=PageURL.logout, method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:"+ PageURL.login;
    }
}
