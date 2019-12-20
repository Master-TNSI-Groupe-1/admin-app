package com.application.controller;

import com.application.configuration.PageURL;
import com.application.configuration.SucessMessage;
import com.application.dto.AjaxResponseBodyDTO;
import com.application.dto.UpdateLocationDTO;
import com.application.entity.Location;
import com.application.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Collectors;

@Controller
@RequestMapping(PageURL.location)
public class LocationController {

    @Autowired
    LocationService locationService;

    @RequestMapping(value = PageURL.locationFind, method = RequestMethod.GET)
    public ResponseEntity<?> findLocationById(@RequestParam(value = "id") Integer locationId) {
        AjaxResponseBodyDTO result = new AjaxResponseBodyDTO();
        if(locationId == null) {
            result.getResult().add(locationService.findAll());
        } else {
            result.getResult().add(locationService.findById(locationId));
        }
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = PageURL.locationCreate, method = RequestMethod.POST)
    public ResponseEntity<?> createLocation(@Valid @RequestBody Location location, Errors errors) {
        AjaxResponseBodyDTO result = new AjaxResponseBodyDTO();

        if (errors.hasErrors()) {

            result.setMsg(errors.getAllErrors()
                    .stream().map(x -> x.getDefaultMessage())
                    .collect(Collectors.joining(",")));

            return ResponseEntity.badRequest().body(result);

        }

        result.getResult().add(locationService.create(location));
        result.setMsg(SucessMessage.locationAdd);

        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = PageURL.locationUpdate, method = RequestMethod.PUT)
    public ResponseEntity<?> updateLocation(@Valid @RequestBody UpdateLocationDTO updateLocationDTO, Errors errors) {
        AjaxResponseBodyDTO result = new AjaxResponseBodyDTO();

        if (errors.hasErrors()) {

            result.setMsg(errors.getAllErrors()
                    .stream().map(x -> x.getDefaultMessage())
                    .collect(Collectors.joining(",")));

            return ResponseEntity.badRequest().body(result);

        }

        result.getResult().add(locationService.update(updateLocationDTO));
        result.setMsg(SucessMessage.locationUpdate);

        return ResponseEntity.ok(result);
    }
}
