package com.example.employee.controller;

import java.util.List;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.dto.EmployeeMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    EmployeeService empService;
    @Autowired
    EmployeeMapping employeeMapping;

    @PostMapping(value="/employees")
    public Employee createEmployee(@RequestBody EmployeeDto empDto) {
        return empService.createEmployee(employeeMapping.mapDtoToEmployee(empDto));
    }

    @GetMapping(value="/employees")
    public List<Employee> readEmployees() {
        return empService.getEmployees();
    }

    @GetMapping(value="/employees/{empId}")
    public Employee readEmployees(@PathVariable(value = "empId") Long id) {
        return empService.getEmployee(id);
    }

    @PutMapping(value="/employees/{empId}")
    public Employee updateEmployees(@PathVariable(value = "empId") Long id, @RequestBody EmployeeDto empDto) {
        return empService.updateEmployee(id, employeeMapping.mapDtoToEmployee(empDto));
    }

    @DeleteMapping(value="/employees/{empId}")
    public void deleteEmployees(@PathVariable(value = "empId") Long id) {
        empService.deleteEmployee(id);
    }
}