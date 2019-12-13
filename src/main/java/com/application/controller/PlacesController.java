package com.application.controller;

import com.application.configuration.PageHTML;
import com.application.configuration.PageURL;
import com.application.dto.PointXY;
import com.application.dto.UsersDTO;
import com.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(PageURL.place)
public class PlacesController {

    @Autowired
    UserService userService;

    @RequestMapping(PageURL.createPlace)
    public String createPlace(Model model) {
        UsersDTO usersDTO = userService.getLoggedUser();
        model.addAttribute("user", usersDTO);

        //TODO MOCK
        List<PointXY> pointXYList = new ArrayList<>();
        PointXY pointXY = new PointXY();
        pointXY.setIdLocation(1);
        pointXY.setIdPoint(2);
        pointXY.setLatitude(10);
        pointXY.setLongitude(15);
        pointXYList.add(pointXY);
        model.addAttribute("points", pointXYList);

        model.addAttribute("newPoint", new PointXY());

        return PageHTML.placeCreate;
    }

    @RequestMapping(PageURL.updatePlace)
    public String updatePlace(Model model) {
        UsersDTO usersDTO = userService.getLoggedUser();
        model.addAttribute("user", usersDTO);
        return PageHTML.placeUpdate;
    }
}
