package com.iiss.instantinsurancesalesserver.service;

import com.iiss.instantinsurancesalesserver.entity.EmployeeEntity;
import com.iiss.instantinsurancesalesserver.model.Employee;
import com.iiss.instantinsurancesalesserver.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {

        try {
            List<EmployeeEntity> employees = employeeRepository.findAll();
            List<Employee> customEmployees = new ArrayList<>();
            employees.stream().forEach(e -> {
                Employee employee = new Employee();
                BeanUtils.copyProperties(e, employee);
                customEmployees.add(employee);
            });
            return customEmployees;
        } catch (Exception e) {
            throw e;
        }
    }

    public String addEmployee(EmployeeEntity employee) {
        try {
            if (!employeeRepository.existsByFirstNameAndLastName(employee.getFirstName(), employee.getLastName())) {
                employeeRepository.save(employee);
                return "Employee Added Successfully.";
            } else {
                return "This employee already exists.";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public String removeEmployee(EmployeeEntity employee) {
        try {
            if (employeeRepository.existsByFirstNameAndLastName(employee.getFirstName(), employee.getLastName())) {
                employeeRepository.delete(employee);
                return "Employee Deleted Successfully.";
        } else {
            return "Employee Does Not Exist.";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public String updateEmployee(EmployeeEntity employee) {
        try {
            if (employeeRepository.existsById(employee.getId())) {
                employeeRepository.save(employee);
                return "Employee Updated Successfully.";
            } else {
                return "Employee Does Not Exist.";
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
