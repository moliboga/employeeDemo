package com.example.employee.controller;

import com.example.employee.model.Department;
import com.example.employee.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartmentController {
    @Autowired
    DepartmentService depService;

    @PostMapping(value="/departments")
    public Department createDepartment(@RequestBody Department dep) {
        return depService.createDepartment(dep);
    }

    @GetMapping(value="/departments")
    public List<Department> readDepartments() {
        return depService.getDepartments();
    }

    @GetMapping(value="/departments/{depId}")
    public Department readDepartments(@PathVariable(value = "depId") Long id) {
        return depService.getDepartment(id);
    }

    @PutMapping(value="/departments/{depId}")
    public Department readDepartments(@PathVariable(value = "depId") Long id, @RequestBody Department depDetails) {
        return depService.updateDepartment(id, depDetails);
    }

    @DeleteMapping(value="/departments/{depId}")
    public void deleteDepartment(@PathVariable(value = "depId") Long id) {
        depService.deleteDepartment(id);
    }
}