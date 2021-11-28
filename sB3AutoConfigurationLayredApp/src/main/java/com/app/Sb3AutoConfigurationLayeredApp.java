package com.app;

import com.app.controller.EmployeeController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author Saurabh Vaish
 * @Date 28-11-2021
 */

@SpringBootApplication
public class Sb3AutoConfigurationLayeredApp {

    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext = SpringApplication.run(Sb3AutoConfigurationLayeredApp.class, args);

        EmployeeController controller = applicationContext.getBean(EmployeeController.class);
    }
}
