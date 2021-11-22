package com.app;

import com.app.dao.EmployeeDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author Saurabh Vaish
 * @Date 22-11-2021
 *
 *  Here we are not defining any configuration related to the database , spring boot autoconfiguration will read the property file and configure the database
 *  we just need to provide the jdbc starter and database driver jar .
 *
 *  by default HikariDataSource will be used as datasource obj and will use pooling to connect to the database .
 *
 *
 *
 */

@SpringBootApplication
public class SbAutoConfiguration {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SbAutoConfiguration.class, args);

        EmployeeDao employeeDao = applicationContext.getBean(EmployeeDao.class);

        System.out.println("Employee Count is ="+employeeDao.getEmployeeCount());

        applicationContext.close();

    }
}
