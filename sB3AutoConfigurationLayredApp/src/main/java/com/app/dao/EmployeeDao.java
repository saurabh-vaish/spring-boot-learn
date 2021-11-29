package com.app.dao;

import com.app.model.Employee;

import java.util.List;

/**
 * @author Saurabh Vaish
 * @Date 29-11-2021
 */
public interface EmployeeDao {

    List<Employee> getEmployeeByDegs(String deg1,String deg2) throws  Exception;
}
