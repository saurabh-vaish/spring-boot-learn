package com.app.dao.impl;

import com.app.dao.PlaceDao;
import com.app.model.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Saurabh Vaish
 * @Date 29-11-2021
 */

@Repository
public class PlaceDaoImpl implements PlaceDao {

    private static final String GET_ALL_PLACES = "SELECT * FROM PLACE P WHERE STATE in(?,?,?) order by STATE";

    @Autowired
    private DataSource ds;

    @Override
    public List<Place> getPlaceByStateNames(String state1, String state2,String state3) throws Exception {

        List<Place> places = new ArrayList<>();
        // try with resources no need to use catch if we use try with resources because it uses finally block internally , and all the resources will be closed automatically
        try(
                Connection connection = ds.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_PLACES))
        {
            preparedStatement.setString(1, state1);
            preparedStatement.setString(2, state2);
            preparedStatement.setString(3, state3);
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    places.add(new Place(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5)));
                }
            }
        }

        return places;
    }
}
