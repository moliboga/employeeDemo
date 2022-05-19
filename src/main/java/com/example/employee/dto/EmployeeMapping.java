package com.example.employee.dto;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.model.Department;
import com.example.employee.model.Employee;
import com.example.employee.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class EmployeeMapping {
    @Autowired
    DepartmentRepository depRepository;

    //из entity в dto
    public EmployeeDto mapEmployeeToDto(Employee entity){
        EmployeeDto dto = new EmployeeDto();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setEmailId(entity.getEmailId());
        dto.setDepartments(entity.getDepartments().stream()
                .map(Department::getId)
                .collect(Collectors.toSet()));
        return dto;
    }
    //из dto в entity
    public Employee mapDtoToEmployee(EmployeeDto dto){
        Employee entity = new Employee();
        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setEmailId(dto.getEmailId());
        entity.setDepartments(dto.getDepartments().stream()
                .map(depId -> depRepository.findById(depId).get())
                .collect(Collectors.toSet()));
        return entity;
    }
}
