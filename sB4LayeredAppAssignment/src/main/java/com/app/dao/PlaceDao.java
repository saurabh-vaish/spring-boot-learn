package com.app.dao;

import com.app.model.Place;

import java.util.List;

/**
 * @author Saurabh Vaish
 * @Date 29-11-2021
 */
public interface PlaceDao {

    List<Place> getPlaceByStateNames(String state1, String state2,String state3) throws  Exception;
}
