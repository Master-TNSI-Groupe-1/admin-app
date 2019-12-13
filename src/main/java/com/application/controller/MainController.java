package com.application.controller;

import com.application.configuration.PageHTML;
import com.application.configuration.PageURL;
import com.application.dto.UsersDTO;
import com.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@Autowired
	UserService userService;

	@RequestMapping(PageURL.all)
	public String defaultUrl() {
		return "redirect:"+ PageURL.home;
	}
	
	@RequestMapping(PageURL.home)
	public String getHome(Model model) {
		UsersDTO usersDTO = (UsersDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", usersDTO);
		return PageHTML.homeHTML;
	}
}
