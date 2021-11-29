package com.app.service.impl;

import com.app.dao.EmployeeDao;
import com.app.model.Employee;
import com.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Saurabh Vaish
 * @Date 29-11-2021
 */

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> getEmployeeByDegs(String deg1, String deg2) throws Exception {
        return employeeDao.getEmployeeByDegs(deg1, deg2);
    }
}
