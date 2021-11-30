package com.app.controller;

import com.app.model.Place;
import com.app.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @author Saurabh Vaish
 * @Date 28-11-2021
 */

@Controller
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    public List<Place> getPlaceByStateNames(String state1, String state2,String state3) throws Exception {
        return placeService.getPlaceByStateNames(state1, state2,state3);
    }

}
