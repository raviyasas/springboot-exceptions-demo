package com.app.controller;

import com.app.entity.Employee;
import com.app.exception.BadRequestException;
import com.app.exception.UserNotFoundException;
import com.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    private EmployeeService employeeService;

    @GetMapping("/getEmployees")
    public List<Employee> getAllEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("/badRequest")
    public void checkBadRequestException(){
        throw new BadRequestException("Invalid request");
    }

    @GetMapping("/userNotFound")
    public void checkUserNotFoundException(){
        throw new UserNotFoundException("User can not be found");
    }
}
