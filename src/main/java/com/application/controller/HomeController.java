package com.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/test")
	public String getHome() {
		System.out.println("On est ici");
		return "index";
	}
	
	@RequestMapping("/")
	public String getHomeStd() {
		return "index";
	}
	
	@RequestMapping("/authenticated")
	public String getAuthenticated() {
		return "secret";
	}
	
}
