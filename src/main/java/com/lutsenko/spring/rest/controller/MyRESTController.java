package com.lutsenko.spring.rest.controller;

import com.lutsenko.spring.rest.entity.Employee;
import com.lutsenko.spring.rest.exeption_handling.EmployeeIncorrectData;
import com.lutsenko.spring.rest.exeption_handling.NoSuchEmployeeExceptiion;
import com.lutsenko.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        List<Employee> allEmployees = employeeService.getAllEmployee();
        return allEmployees;
    }


    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {

        Employee employee = employeeService.getEmployee(id);

        if(employee == null){
            throw new NoSuchEmployeeExceptiion("There is no employee with id = " +
                    id+ " in Database");
        }

        return employee;

    }
    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee){


        employeeService.saveEmployee(employee);

        return employee;

    }

@PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }

@DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
       Employee employee= employeeService.getEmployee(id);
       if(employee == null){
           throw new NoSuchEmployeeExceptiion(" There is no employee with ID = "+ id);
       }
        employeeService.deleteEmployee(id);
        return "Employee with ID" + id + "was delete!";
}

}
