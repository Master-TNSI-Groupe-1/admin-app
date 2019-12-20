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
    public ResponseEntity<?> findLocation(@RequestParam(value = "locationId") final Integer locationId, @RequestParam(value = "siteId") final Integer siteId) {
        final AjaxResponseBodyDTO result = new AjaxResponseBodyDTO();

        if(locationId != null) {
            result.getResult().add(locationService.findById(locationId));
        }
        if(siteId != null) {
            result.getResult().add(locationService.findAllBySite(siteId));
        }
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = PageURL.locationCreate, method = RequestMethod.POST)
    public ResponseEntity<?> createLocation(@Valid @RequestBody final Location location, final Errors errors) {
        final AjaxResponseBodyDTO result = new AjaxResponseBodyDTO();

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
    public ResponseEntity<?> updateLocation(@Valid @RequestBody final UpdateLocationDTO updateLocationDTO, final Errors errors) {
        final AjaxResponseBodyDTO result = new AjaxResponseBodyDTO();

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
