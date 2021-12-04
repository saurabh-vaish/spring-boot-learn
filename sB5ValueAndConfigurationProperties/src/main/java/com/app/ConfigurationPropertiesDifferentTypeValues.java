package com.app;

import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
@PropertySource("classpath:user-defined.properties")            // used here because want to read properties from user defined properties
@ConfigurationProperties(prefix="per.info")  // used to bulk read the properties from the properties file
public class ConfigurationPropertiesDifferentTypeValues {

    //simple/wrapper type
    private Integer pid;
    private String    pname;
    //array type
    private  String[] favColors;
    //List-Collection type
    private List<String> studies;
    //Set- Collection type
    private Set<Long> phoneNumbers;
    //Map-Collection type
    private Map<String,Object> idDetails;

    //HAS-A type  (composition)
    private JobInfo jobInfo;    // here JobInfo object creation and value injection is taking care by @ConfigurationProperties

    @Override
    public String toString() {
        return "PersonInfo [pid=" + pid + ", pname=" + pname + ", favColors=" + Arrays.toString(favColors)
                + ", studies=" + studies + ", phoneNumbers=" + phoneNumbers + ", idDetails=" + idDetails + ", jobInfo="
                + jobInfo + "]";
    }
}
