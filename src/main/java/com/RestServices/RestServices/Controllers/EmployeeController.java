package com.RestServices.RestServices.Controllers;

import com.RestServices.RestServices.Pojos.Employee;
import com.RestServices.RestServices.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee){
         return employeeService.saveOrUpdate(employee);
    }
    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.saveOrUpdate(employee);
    }
    @DeleteMapping("/employee/{empId}")
    public String deleteEmployee(@PathVariable int empId){
        Employee employee=employeeService.findById(empId);
        if(employee==null){
            throw new RuntimeException("Not Found Employee Id - "+empId);
        }
        employeeService.delete(employee);
        return "Deleted employee - id:"+empId;
    }
    @GetMapping("/employee/{empId}")
    public Employee getEmployee(@PathVariable int empId){
        Employee employee=employeeService.findById(empId);
        if(employee==null){
            throw new RuntimeException("Not Found Employee Id - "+empId);
        }
       return employee;
    }
}
