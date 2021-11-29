package com.app.controller;

import com.app.model.Employee;
import com.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @author Saurabh Vaish
 * @Date 28-11-2021
 */

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    public List<Employee> getEmployees(String deg1,String deg2) throws Exception {
        return employeeService.getEmployeeByDegs(deg1,deg2);
    }

}
