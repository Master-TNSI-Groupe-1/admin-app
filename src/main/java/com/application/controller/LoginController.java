package com.application.controller;

import com.application.configuration.ErrorMessage;
import com.application.configuration.PageHTML;
import com.application.configuration.PageURL;
import com.application.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    TestService testService;

    @RequestMapping(PageURL.login)
    public String login() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!(auth instanceof AnonymousAuthenticationToken)) {
            return "redirect:"+ PageURL.home;
        }
        return PageHTML.loginHTML;
    }

    @RequestMapping(PageURL.loginError)
    public String login(HttpServletRequest request, Model model) {
        model.addAttribute("errorMessage", ErrorMessage.badCredential);
        return PageHTML.loginHTML;
    }
}
