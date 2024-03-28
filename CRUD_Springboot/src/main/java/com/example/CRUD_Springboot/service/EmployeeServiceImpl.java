package com.example.CRUD_Springboot.service;

import com.example.CRUD_Springboot.entity.Employee;
import com.example.CRUD_Springboot.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee postEmployee(Employee employee) {
//        employee.setId(Long.valueOf(UUID.randomUUID().toString()));
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {

        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee existingEmployee = optionalEmployee.get();
            existingEmployee.setName(employee.getName());
            existingEmployee.setEmail(employee.getEmail());
            existingEmployee.setMobileNumber(employee.getMobileNumber());
            existingEmployee.setDob(employee.getDob());
            existingEmployee.setAddress(employee.getAddress());
            return employeeRepository.save(existingEmployee);
        } else {
            throw new EntityNotFoundException("Employee with id " + id + " not found");
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) throws RuntimeException {
        return employeeRepository.findEmployeeById(id).orElseThrow(()->new RuntimeException("User not found"));
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
