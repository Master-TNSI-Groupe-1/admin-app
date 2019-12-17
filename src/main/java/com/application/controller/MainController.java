package com.application.controller;

import com.application.configuration.PageHTML;
import com.application.configuration.PageURL;
import com.application.entity.Users;
import com.application.service.SiteService;
import com.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@Autowired
	UserService userService;

	@Autowired
	SiteService siteService;

	@RequestMapping(PageURL.all)
	public String defaultUrl() {
		return "redirect:"+ PageURL.home;
	}
	
	@RequestMapping(PageURL.home)
	public String getHome(Model model) {
		model.addAttribute("user", userService.getLoggedUser());
		return PageHTML.home;
	}
}
