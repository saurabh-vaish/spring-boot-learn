package com.app.service.impl;

import com.app.dao.PlaceDao;
import com.app.model.Place;
import com.app.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Saurabh Vaish
 * @Date 29-11-2021
 */

@Service
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    private PlaceDao placeDao;

    @Override
    public List<Place> getPlaceByStateNames(String state1, String state2,String state3) throws Exception {
        return placeDao.getPlaceByStateNames(state1, state2, state3);
    }
}
