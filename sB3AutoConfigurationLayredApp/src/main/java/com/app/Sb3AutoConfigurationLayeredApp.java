package com.app;

import com.app.controller.EmployeeController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

/**
 * @author Saurabh Vaish
 * @Date 28-11-2021
 */

@SpringBootApplication
public class Sb3AutoConfigurationLayeredApp {

    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext = SpringApplication.run(Sb3AutoConfigurationLayeredApp.class, args);

        EmployeeController controller = applicationContext.getBean(EmployeeController.class);

        try {
            controller.getEmployees("manager", "developer").forEach(System.out::println);
        }    catch (Exception e) {
            e.printStackTrace();
        }
//        Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(System.out::println);
        applicationContext.close();

    }
}
