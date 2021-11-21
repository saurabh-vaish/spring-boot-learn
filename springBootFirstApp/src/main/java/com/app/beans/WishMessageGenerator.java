package com.app.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;

/**
 * @author Saurabh Vaish
 * @Date 21-11-2021
 */

@Component
public class WishMessageGenerator {

    @Autowired
    private Calendar calendar;   // Injecting the calendar dependency , will give GeororianCalendar instance

    public String getWishMessage(String userName) {
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        if (hour < 12) {
            return "Good Morning "+ userName;
        } else if (hour < 16) {
            return "Good Afternoon "+ userName ;
        } else if (hour < 20) {
            return "Good Evening "+ userName;
        } else {
            return "Good Night "+userName;
        }
    }
}
