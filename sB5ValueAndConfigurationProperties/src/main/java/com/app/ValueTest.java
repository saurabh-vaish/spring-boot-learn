package com.app;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author Saurabh Vaish
 * @Date 04-12-2021
 *
 * @Value = It is given to inject values gathered from properties file / system properties / environment variables or direct values to spring bean.
 *          It injects one value at a time.
 *          It also evaluates the expression for SPEL language and injects the result to spring bean .
 *
 *     ***  It performs Field injection to inject values to properties of spring bean.
 *
 *          It can also inject the spring bean using spel
 *
 *          it will throw illegal argument exception if the value is not found
 *
 *          It gets the value in string format then converts and do autoboxing and unboxing accordingly
 *
 *  Order of Searching -->
 *
 *          1. User defined property file
 *          2. application.properties file
 *          3. system.properties
 *          4. env.variables
 *
 *      so if a property if common in all the above files then it will get replaced with the values where it will get find in last
 *
 *
 *
 *  *** ${...}  = Placeholder syntax used to inject values from  properties.
 *
 *      #{...} = Expression syntax.  used to evaluate expressions
 *
 *
 *
 *      @PropertySource : It is used to load the properties file from the classpath.
 *
 *
 *  @ConfigurationProperties == It is used to bulk read the properties from the properties file
 *  *                             It uses setter injection to inject values
 *  *                             The valriables name must match the property name defiend in the properties file
 *  *
 *  *
 *  *        *****  If we are using @value and @ConfigurationProperties annotation together then value coming from the @ConfigurationProperties annotation will be taken as final value
 *  *              as it perfrom the setter injection so it will override the value coming from @value annotation as it uses field injection
 *  *
 *  *
 *
 *
 */

@Component
public class ValueTest {

    @Value("Saurabh")   // direct value injection
    private String name;

    @Value("#{10+20}")      // SPEL expression
    private int age;

    @Value("${hsptl.name}")         // injecting values from properties with help of using spel expression
    private String hospitalName;

    @Value("${hsptl.address}")
    private String hospitalAddress;


    @Value("${os.name}")            // injecting values from system properties
    private String osName;


    @Value("${Path}")                // injecting values from environment variables
    private String path;


    @Value("#{customPropertySource}")              // injecting bean with help of spel expression using field injection
    private PropertySourceTest propertySourceTest;


    @Value("${os.name}")                // common property in application.properties ,customPropertySource.properties and system properties
    private String commonOsName;

    @Value("${common.name}")                // common property in application.properties ,customPropertySource.properties
    private String commonName;



    @Override
    public String toString() {
        return "ValueTest{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hospitalName='" + hospitalName + '\'' +
                ", hospitalAddress='" + hospitalAddress + '\'' +
                ", osName='" + osName + '\'' + '\n' +
                ", path='" + path + '\'' + '\n' +
                ", propertySourceTest=" + propertySourceTest + '\n' +
                ", commonOsName='" + commonOsName + '\'' + '\n' +
                ", commonName='" + commonName + '\'' +
                '}';
    }
}
