package com.RestServices.RestServices.Dao;

import com.RestServices.RestServices.Pojos.Employee;

import java.util.List;

public interface EmployeeDao {
    public List<Employee> getEmployees();

    public  Employee saveOrUpdate(Employee employee);

    public Employee findById(int empId);

    public void delete(Employee employee);
}
