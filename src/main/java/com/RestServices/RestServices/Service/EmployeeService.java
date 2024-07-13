package com.RestServices.RestServices.Service;

import com.RestServices.RestServices.Pojos.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getEmployees();

    public  Employee saveOrUpdate(Employee employee);

    public Employee findById(int empId);

    public void delete(Employee employee);
}
