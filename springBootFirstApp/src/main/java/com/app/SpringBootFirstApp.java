package com.app;

import com.app.beans.WishMessageGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Calendar;

/**
 * @author Saurabh Vaish
 * @Date 20-11-2021
 *
 * @SpringBootApplication = @Configuration ( or @SpringBootConfiguration) + @EnableAutoConfiguration + @ComponentScan
 *
 * @ComponentScan = It automatically scans the current package and sub packages for classes annotated with Stereotype annotations and make them as spring brings .
 *                  In that process it also recognizes the classes annotated with @Configuration .
 *
 * @Configuration or @SpringBootConfiguration = It is used to mark a class as a configuration class. Currently it makes the main class as a configuration class to make the predefined classes as spring beans.
 *                                               annotated with @Bean annotation.
 *
 *
 * @EnableAutoConfiguration = It performs the autoconfiguration during the application startup based on the starters added in pom.xml . In this process it creates the beans of the
 *                           pre-defined classes given in the starter that are necessary in dependency injections
 *
 * Spring boot app start -->
 *
 *  1. Flow starts from main method , it will run all the things before the SpringApplication.run() method
 *
 *  2. SpringApplication.run(,) method bootstraps the spring boot application by doing the following things .
 *
 *  3. Prepares all the things that needed to run the applications and print banner .
 *
 *  4. Locates and loads application.properties/yml file then checks for the active profile and based on that profile related object is created .
 *
 *  5. Created the IOC container of type ApplicationContext (I) and creates the object based on the web application type .
 *      --> If it is standalone  →  AnnotationConfigApplicationContext
 *      --> If it is web app  →  AnnotationConfigServletWebServerApplicationContext
 *      --> If reactive web app  →  AnnotationConfigReactiveWebServerApplicationContext
 *
 *  6. IOC Container takes the current class as the configuration class and in that process the configuration class object will be created .
 *
 *  7. Checks the starters (jar files ) that are added in the build path and does the corresponding autoconfiguration , in this process creates beans of predefined classes
 *      and perform the dependency injection.
 *
 *  8. After the autoconfiguration is performed @ComponentScan of @SpringBootApplication will scans the classes for stereotype annotations and create beans having singleton scopes .
 *      It also creates the beans of the classes annotated with @Configuration and @Bean annotation and performs the dependency injection .
 *
 *  9. ALl the above beans that are created by IOC container will be placed in Internal Cache of IOC Container .
 *      that is a hashmap having keys as the bean name and values as the reference to the bean object.
 *
 *  10. After the bootstrapping is done it executes the remaining things in the main method and call business methods .
 *
 *  11. Once the close() is called on IOC Container then all the beans that are created by IOC container will be destroyed and
 *      the internal cache of IOC Container will be cleared and many other objects will be destroyed.
 *
 *
 *
 *
 */

@SpringBootApplication
public class SpringBootFirstApp {


    @Bean
    public Calendar calendar(){return Calendar.getInstance();}  // creating bean for calendar


    public static void main(String[] args) {

        System.out.println("main method start =============");

        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBootFirstApp.class, args);  // will return the IOC container objcet ref based on application type

        WishMessageGenerator bean = applicationContext.getBean(WishMessageGenerator.class); // getting bean

        System.out.println(bean.getWishMessage("srv"));

//        Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(System.out::println); // will print the beans

        applicationContext.close(); // closing the application context and destroying all the beans

        System.out.println("main method ends");
    }
}
