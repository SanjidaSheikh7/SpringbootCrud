package com.example.CRUD_Springboot.service;

import com.example.CRUD_Springboot.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee postEmployee(Employee employee);
    public Employee updateEmployee(Long id,Employee employee);
    public List<Employee> getAllEmployees();
    public Employee getEmployeeById(Long id) throws RuntimeException;
    public void deleteEmployee(Long id);
}
