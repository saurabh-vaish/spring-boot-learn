package com.app.dao.impl;

import com.app.dao.EmployeeDao;
import com.app.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Saurabh Vaish
 * @Date 29-11-2021
 */

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {

    private static final String GET_ALL_EMPLOYEES = "SELECT * FROM EMPLOYEE2 EMP WHERE job in(?,?) order by job";

    @Autowired
    private DataSource ds;

    @Override
    public List<Employee> getEmployeeByDegs(String deg1, String deg2) throws Exception {

        List<Employee> employees = new ArrayList<>();
        // try with resources no need to use catch if we use try with resources because it uses finally block internally , and all the resources will be closed automatically
        try(
                Connection connection = ds.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_EMPLOYEES))
        {
            preparedStatement.setString(1, deg1);
            preparedStatement.setString(2, deg2);
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    employees.add(new Employee(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3), resultSet.getDouble(4), resultSet.getString(5)));
                }
            }
        }

        return employees;
    }
}
