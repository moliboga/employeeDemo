package com.example.employee.controller;

import java.util.List;

import com.example.employee.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    EmployeeService empService;

    @RequestMapping(value="/employees", method=RequestMethod.POST)
    public Employee createEmployee(@RequestBody Employee emp) {
        System.out.println();
        return empService.createEmployee(emp);
    }

    @RequestMapping(value="/employees", method=RequestMethod.GET)
    public List<Employee> readEmployees() {
        return empService.getEmployees();
    }

    @RequestMapping(value="/employees/{empId}", method=RequestMethod.GET)
    public Employee readEmployees(@PathVariable(value = "empId") Long id) {
        return empService.getEmployee(id);
    }

    @RequestMapping(value="/employees/{empId}", method=RequestMethod.PUT)
    public Employee readEmployees(@PathVariable(value = "empId") Long id, @RequestBody Employee empDetails) {
        return empService.updateEmployee(id, empDetails);
    }

    @RequestMapping(value="/employees/{empId}", method=RequestMethod.DELETE)
    public void deleteEmployees(@PathVariable(value = "empId") Long id) {
        empService.deleteEmployee(id);
    }

//    @PutMapping(value="/employees/{empId}/{depId}")
//    public void addDepartment(@PathVariable(value = "empId") Long empId, @PathVariable(value = "depId") Long depId) {
//        empService.addDepartment(empId, depId);
//    }
//
//    @DeleteMapping(value="/employees/{empId}/{depId}")
//    public void deleteDepartment(@PathVariable(value = "empId") Long empId, @PathVariable(value = "depId") Long depId) {
//        empService.deleteDepartment(empId, depId);
//    }
}