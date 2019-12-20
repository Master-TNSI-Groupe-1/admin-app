package com.application.controller;

import com.application.configuration.PageURL;
import com.application.dto.AjaxResponseBodyDTO;
import com.application.dto.NewPointXYDTO;
import com.application.service.PointXYService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.stream.Collectors;

@Controller
@RequestMapping(PageURL.pointXY)
public class PointXYController {

    @Autowired
    PointXYService pointXYService;

    @RequestMapping(value = PageURL.createPointXY, method = RequestMethod.POST)
    public ResponseEntity<?> addPointXY(@Valid @RequestBody NewPointXYDTO newPointXYDTO, Errors errors) {
        AjaxResponseBodyDTO result = new AjaxResponseBodyDTO();

        if (errors.hasErrors()) {
            result.setMsg(errors.getAllErrors()
                    .stream().map(x -> x.getDefaultMessage())
                    .collect(Collectors.joining(",")));
            return ResponseEntity.badRequest().body(result);
        }
        result.getResult().add(pointXYService.addPointsXY(newPointXYDTO));
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = PageURL.removePointXY, method = RequestMethod.DELETE)
    public ResponseEntity<?> removePointXY(@Valid @RequestBody Integer idPoint, Errors errors) {
        AjaxResponseBodyDTO result = new AjaxResponseBodyDTO();

        if (errors.hasErrors()) {
            result.setMsg(errors.getAllErrors()
                    .stream().map(x -> x.getDefaultMessage())
                    .collect(Collectors.joining(",")));
            return ResponseEntity.badRequest().body(result);
        }
        pointXYService.deleteById(idPoint);
        return ResponseEntity.ok(result);
    }
}
