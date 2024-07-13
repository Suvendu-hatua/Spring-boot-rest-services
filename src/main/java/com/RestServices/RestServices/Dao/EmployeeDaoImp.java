package com.RestServices.RestServices.Dao;

import com.RestServices.RestServices.Pojos.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImp implements EmployeeDao {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDaoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> getEmployees() {
        TypedQuery<Employee> empList=entityManager.createQuery("from Employee",Employee.class);
        return empList.getResultList();
    }

    @Override
    public Employee saveOrUpdate(Employee employee) {
       Employee theEmployee= entityManager.merge(employee);
        return theEmployee;
    }

    @Override
    public Employee findById(int empId) {
        return entityManager.find(Employee.class,empId);
    }

    @Override
    public void delete(Employee employee) {
        entityManager.remove(employee);
    }
}
