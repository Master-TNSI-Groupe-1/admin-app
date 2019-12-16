package com.application.controller;

import com.application.configuration.PageHTML;
import com.application.configuration.PageURL;
import com.application.entity.PointXY;
import com.application.entity.Users;
import com.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(PageURL.place)
public class PlacesController {

    @Autowired
    UserService userService;

    @RequestMapping(PageURL.createPlace)
    public String createPlace(Model model) {
        Users usersDTO = userService.getLoggedUser();
        model.addAttribute("user", usersDTO);

        model.addAttribute("newPoint", new PointXY());

        return PageHTML.placeCreate;
    }

    @RequestMapping(PageURL.updatePlace)
    public String updatePlace(Model model) {
        Users usersDTO = userService.getLoggedUser();
        model.addAttribute("user", usersDTO);
        return PageHTML.placeUpdate;
    }
}
