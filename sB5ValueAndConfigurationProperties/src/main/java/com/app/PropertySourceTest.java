package com.app;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 *
 * @PropertySource : It is used to load the properties file from the classpath.
 *
 *
 * @author Saurabh Vaish
 * @Date 04-12-2021
 */

@Data
@Component("customPropertySource")
@PropertySource("classpath:myCustom.properties")   // reading custom properties file
public class PropertySourceTest {

    @Value("${app.name}")
    private String appName;

    @Value("${app.version}")
    private String appVersion;

    @Value("${os.name}")                // common property in application.properties ,customPropertySource.properties and system properties
    private String commonOsName;

    @Value("${common.name}")                // common property in application.properties ,customPropertySource.properties
    private String commonName;

}
