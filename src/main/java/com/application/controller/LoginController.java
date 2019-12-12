package com.application.controller;

import com.application.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @Autowired
    TestService testService;

    @RequestMapping("/login")
    public String test() {
        return "login";
    }
}
