package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class SB5ValueAndConfigurationPropertiesApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(SB5ValueAndConfigurationPropertiesApplication.class, args);

		ValueTest valueTest = applicationContext.getBean(ValueTest.class);

		System.out.println("ValueTest.value: " + valueTest);

		ConfigurationPropertiesTest configurationPropertiesTest = applicationContext.getBean(ConfigurationPropertiesTest.class);

		System.out.println("ConfigurationPropertiesTest.value: " + configurationPropertiesTest);

		ConfigurationPropertiesDifferentTypeValues propertiesDifferentTypeValues = applicationContext.getBean(ConfigurationPropertiesDifferentTypeValues.class);

		System.out.println("ConfigurationPropertiesDifferentTypeValues.value: " + propertiesDifferentTypeValues);


		ConfigurableEnvironment environment = applicationContext.getEnvironment();
//		System.out.println(environment.getSystemProperties());

	}

}
