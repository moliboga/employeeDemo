package com.example.employee.dto;

import com.example.employee.model.Department;
import lombok.Data;

import java.util.Set;

@Data
public class EmployeeDto {
    Long id;
    String firstName;
    String lastName;
    String emailId;
    Set<Long> departments;
}
