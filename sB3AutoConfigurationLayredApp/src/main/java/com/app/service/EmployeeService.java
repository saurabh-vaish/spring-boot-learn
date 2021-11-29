package com.app.service;

import com.app.model.Employee;

import java.util.List;

/**
 * @author Saurabh Vaish
 * @Date 29-11-2021
 */
public interface EmployeeService {

    List<Employee> getEmployeeByDegs(String deg1, String deg2) throws Exception;
}
