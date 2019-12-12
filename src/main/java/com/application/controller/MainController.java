package com.application.controller;

import com.application.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@Autowired
	TestService testService;

	@RequestMapping("/test")
	public String test() {
		System.out.println("On est ici");
		System.out.println(testService.getAllTest());
		return "main";
	}
	
	@RequestMapping("/")
	public String getHome() {
		return "main";
	}
	
	@RequestMapping("/authenticated")
	public String getAuthenticated() {
		return "secret";
	}
	
}
