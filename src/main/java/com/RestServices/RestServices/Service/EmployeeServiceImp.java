package com.RestServices.RestServices.Service;

import com.RestServices.RestServices.Dao.EmployeeDao;
import com.RestServices.RestServices.Pojos.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService{
    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImp(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeDao.getEmployees();
    }

    @Override
    @Transactional
    public Employee saveOrUpdate(Employee employee) {
        return employeeDao.saveOrUpdate(employee);
    }

    @Override
    public Employee findById(int empId) {
        return employeeDao.findById(empId);
    }

    @Override
    @Transactional
    public void delete(Employee employee) {
        employeeDao.delete(employee);
    }
}
