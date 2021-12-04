package com.app;

import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *
 * @ConfigurationProperties == It is used to bulk read the properties from the properties file
 *                             It uses setter injection to inject values
 *                             The valriables name must match the property name defiend in the properties file
 *
 *
 *        *****  If we are using @value and @ConfigurationProperties annotation together then value coming from the @ConfigurationProperties annotation will be taken as final value
 *              as it perfrom the setter injection so it will override the value coming from @value annotation as it uses field injection
 *
 *
 *
 * @author Saurabh Vaish
 * @Date 04-12-2021
 */

@Setter   // it is mandatory if we want to use @ConfigurationProperties as it uses setter injection to inject values
@ToString
@Component
@ConfigurationProperties(prefix="com.info")  // used to bulk read the properties from the properties file
public class ConfigurationPropertiesTest {

    @Value("${hsptl.name}")   // will get overridden by @ConfigurationProperties
    private String name;

    private String age;

    private String address;

    private String salary;


    public ConfigurationPropertiesTest() {
        System.out.println(" no arg constructor, name value  :::"+name);

}


    public void setName(String name) {
        System.out.println("value before setter name = " + name);
        this.name = name;
    }
}
