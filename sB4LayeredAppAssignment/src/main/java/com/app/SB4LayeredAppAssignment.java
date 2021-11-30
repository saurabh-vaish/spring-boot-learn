package com.app;


import com.app.controller.PlaceController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class SB4LayeredAppAssignment {

    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext = SpringApplication.run(SB4LayeredAppAssignment.class, args);

        PlaceController controller = applicationContext.getBean(PlaceController.class);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first state name");
        String firstState = scanner.nextLine();
        System.out.println("Enter the second state name");
        String secondState = scanner.nextLine();
        System.out.println("Enter the third state name");
        String thirdState = scanner.nextLine();

        try {
            controller.getPlaceByStateNames(firstState, secondState, thirdState).forEach(System.out::println);
        }    catch (Exception e) {
            System.out.println(e.getMessage());
        }

        applicationContext.close();
    }
}
