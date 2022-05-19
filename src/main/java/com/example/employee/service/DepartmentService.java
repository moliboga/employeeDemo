package com.example.employee.service;

import com.example.employee.model.Department;
import com.example.employee.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository depRepository;

    // CREATE
    public Department createDepartment(Department dep) {
        return depRepository.save(dep);
    }

    // READ
    public List<Department> getDepartments() {
        return depRepository.findAll();
    }

    public Department getDepartment(Long depId){
        return depRepository.findById(depId).get();
    }

    // DELETE
    public void deleteDepartment(Long depId) {
        depRepository.deleteById(depId);
    }

    // UPDATE
    public Department updateDepartment(Long depId, Department departmentDetails) {
        Department dep = depRepository.findById(depId).get();
        dep.setId(departmentDetails.getId());
        dep.setDepartmentName(departmentDetails.getDepartmentName());
        dep.setLocationId(departmentDetails.getLocationId());
        return depRepository.save(dep);
    }
}