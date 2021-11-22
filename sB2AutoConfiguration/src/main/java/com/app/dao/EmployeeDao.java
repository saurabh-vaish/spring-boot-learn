package com.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Saurabh Vaish
 * @Date 22-11-2021
 */

@Component
public class EmployeeDao {

    private static final String COUNT_EMPLOYEES = "SELECT count(*) FROM EMPLOYEE";

    @Autowired
    private DataSource dataSource;


    public Integer getEmployeeCount() throws Exception {

        System.out.println("datasource injected impl class name = "+dataSource.getClass().getName());  // by default HikariDatasource class will come as obj

        Connection con = dataSource.getConnection();

        PreparedStatement statement = con.prepareStatement(COUNT_EMPLOYEES);

        ResultSet resultSet = statement.executeQuery();

        boolean next = resultSet.next();

        int count = resultSet.getInt(1);

        resultSet.close();
        con.close();

        return count;
    }

}
