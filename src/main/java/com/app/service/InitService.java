package com.app.service;

import com.app.entity.Employee;
import com.app.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class InitService {

    @Autowired
    public InitService(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }

    private EmployeeRepository employeeRepository;

    @Bean
    public void addEmployees(){
        List<Employee> employeeList = Arrays.asList(
                new Employee(1, "ann", "ann@live.com"),
                new Employee(2, "john", "john@live.com"),
                new Employee(3, "Lisa", "lisa@gmail.com")
        );

        employeeRepository.saveAll(employeeList);
    }
}
