package com.iiss.instantinsurancesalesserver.controller;

import com.iiss.instantinsurancesalesserver.entity.EmployeeEntity;
import com.iiss.instantinsurancesalesserver.model.Employee;
import com.iiss.instantinsurancesalesserver.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
//@RequestMapping("api/v2/")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "getallemployees", method = RequestMethod.GET)
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @RequestMapping(value = "addemployee", method = RequestMethod.POST)
    public String addEmployee(@RequestBody EmployeeEntity employee){
        return employeeService.addEmployee(employee);
    }

    @RequestMapping(value = "updateemployee", method = RequestMethod.PUT)
    public String updateEmployee(@RequestBody EmployeeEntity employee){
        return employeeService.updateEmployee(employee);
    }

    @RequestMapping(value = "deleteemployee", method = RequestMethod.DELETE)
    public String removeEmployee(@RequestBody EmployeeEntity employee) {
        return employeeService.removeEmployee(employee);
    }
}
